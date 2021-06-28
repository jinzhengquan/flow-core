package cn.flow.engine.factory;

import cn.flow.engine.model.FlowDeployModel;
import cn.flow.engine.model.FlowModel;
import org.springframework.stereotype.Component;

@Component
public class FlowModelDeployFactory {

    public FlowDeployModel createFlowModelDeploy(FlowModel flowModel, String createdBy) {
        return new FlowDeployModel(flowModel.getId(),
                flowModel.getFlowModelName(),
                flowModel.getFlowCategory(),
                flowModel.getFlowModelVersion(),
                createdBy);
    }
}
