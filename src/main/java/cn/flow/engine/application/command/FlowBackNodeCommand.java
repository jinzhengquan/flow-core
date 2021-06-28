package cn.flow.engine.application.command;

import lombok.Data;
import cn.flow.core.common.ErrorCodes;

import javax.validation.constraints.NotBlank;

@Data
public class FlowBackNodeCommand {

    @NotBlank(message = ErrorCodes.INVALIDATE_FLOW_TASK_ID_IS_NULL)
    String flowTaskId;

    @NotBlank(message = ErrorCodes.INVALIDATE_FLOW_OPERATOR_IS_NULL)
    String flowOperator;
}
