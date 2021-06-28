package cn.flow.query.mapper;

import cn.flow.engine.model.FlowDeployNode;
import cn.flow.query.view.FlowNodeBriefView;
import org.springframework.stereotype.Component;

@Component
public class FlowDeployNodeMapper {

    public FlowNodeBriefView flowDeployNodeToMapper(FlowDeployNode flowDeployNode) {
        return new FlowNodeBriefView(flowDeployNode.getNodeId(),
                flowDeployNode.getNodeName(),
                flowDeployNode.getNodeType(),
                flowDeployNode.getFlowDeployModelId());
    }

}
