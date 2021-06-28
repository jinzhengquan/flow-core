package cn.flow.engine.factory;

import cn.flow.engine.application.command.FlowModelCreateCmd;
import cn.flow.engine.model.FlowCategory;
import cn.flow.engine.model.FlowModel;

public class FlowModelFactory {

    public FlowModel createFlowModel(FlowModelCreateCmd command, FlowCategory flowCategory) {
        return new FlowModel(command.getFlowModelName(), flowCategory, command.getCreatedBy());
    }

}
