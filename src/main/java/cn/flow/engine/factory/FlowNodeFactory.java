package cn.flow.engine.factory;

import cn.flow.core.enums.FlowNodeType;
import cn.flow.engine.application.command.FlowNodeCreateCmd;
import cn.flow.engine.model.FlowModel;
import cn.flow.engine.model.FlowNode;
import org.springframework.stereotype.Component;

@Component
public class FlowNodeFactory {

    public FlowNode createFlowNode(FlowNodeCreateCmd command, FlowModel flowModel) {
        return new FlowNode(command.getNodeName(),
                FlowNodeType.valueOf(command.getNodeType()),
                flowModel,
                command.getCreatedBy());
    }
}
