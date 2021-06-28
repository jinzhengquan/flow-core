package cn.flow.engine.factory;

import cn.flow.engine.model.FlowDeployNodeOperator;
import lombok.RequiredArgsConstructor;
import cn.flow.engine.model.FlowNodeOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FlowDeployNodeOperatorFactory {

    public List<FlowDeployNodeOperator> createFlowDeployNodeOperatorFactory(List<FlowNodeOperator> flowNodeOperators,
                                                                            String flowDeployModelId,
                                                                            String createdBy) {
        return flowNodeOperators.stream()
                .map(nodeOperator -> createFlowDeployNodeOperator(nodeOperator, flowDeployModelId, createdBy))
                .collect(Collectors.toList());
    }

    private FlowDeployNodeOperator createFlowDeployNodeOperator(FlowNodeOperator flowNodeOperator,
                                                                       String flowDeployModelId,
                                                                       String createdBy) {
        return new FlowDeployNodeOperator(flowNodeOperator.getFlowModel().getId(),
                flowNodeOperator.getFlowNode().getId(),
                flowNodeOperator.getOperator(),
                flowNodeOperator.getRole(),
                flowDeployModelId,
                createdBy);
    }

}
