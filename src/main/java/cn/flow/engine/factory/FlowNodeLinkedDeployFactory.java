package cn.flow.engine.factory;

import cn.flow.engine.model.FlowDeployModel;
import cn.flow.engine.model.FlowDeployNodeLinked;
import cn.flow.engine.model.FlowNodeLinked;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FlowNodeLinkedDeployFactory {


    public List<FlowDeployNodeLinked> createFlowNodeLinkedDeploy(List<FlowNodeLinked> flowNodeLinked,
                                                                 FlowDeployModel flowDeployModel,
                                                                 String createdBy) {
        return flowNodeLinked.stream().map(node -> createFlowNodeLinkedDeploy(node, flowDeployModel, createdBy))
                .collect(Collectors.toList());
    }

    private FlowDeployNodeLinked createFlowNodeLinkedDeploy(FlowNodeLinked flowNodeLinked,
                                                            FlowDeployModel flowDeployModel,
                                                            String createdBy) {
        return new FlowDeployNodeLinked(flowNodeLinked.getStartNode().getId(),
                flowNodeLinked.getEndNode().getId(),
                flowDeployModel.getId(),
                createdBy);
    }
}
