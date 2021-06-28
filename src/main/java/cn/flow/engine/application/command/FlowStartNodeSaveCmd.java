package cn.flow.engine.application.command;

import lombok.Data;
import cn.flow.core.common.ErrorCodes;

import javax.validation.constraints.NotBlank;

@Data
public class FlowStartNodeSaveCmd {

    @NotBlank(message = ErrorCodes.INVALIDATE_FLOW_DEPLOY_MODEL_ID_IS_NULL)
    String flowDeployModelId;

    String flowNodeId;

    @NotBlank(message = ErrorCodes.INVALIDATE_FLOW_OPERATOR_IS_NULL)
    String flowOperator;
}
