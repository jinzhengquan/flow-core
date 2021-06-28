package cn.flow.engine.factory;

import cn.flow.engine.model.FlowDeployModel;
import cn.flow.engine.model.FlowDeployNode;
import cn.flow.engine.model.FlowNode;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FlowNodeDeployFactory {

    public List<FlowDeployNode> createFlowNodeDeploy(List<FlowNode> flowNodes,
                                                     FlowDeployModel flowDeployModel,
                                                     String createdBy) {
        return flowNodes.stream().map(node -> createFlowNodeDeploy(node, flowDeployModel, createdBy))
                .collect(Collectors.toList());
    }

    private FlowDeployNode createFlowNodeDeploy(FlowNode flowNode, FlowDeployModel flowDeployModel, String createdBy) {
        return new FlowDeployNode(flowNode.getId(),
                flowNode.getNodeName(),
                flowNode.getNodeType(),
                flowDeployModel.getId(),
                flowDeployModel.getFlowModelName(),
                createdBy);
    }
}
