package cn.flow.engine.application.command;

import lombok.Data;
import cn.flow.core.common.ErrorCodes;

import javax.validation.constraints.NotBlank;

@Data
public class FlowNodeLinkedEditCmd {

    @NotBlank(message = ErrorCodes.INVALIDATE_FLOW_NODE_LINKED_ID_IS_NULL)
    private String id;

    @NotBlank(message = ErrorCodes.INVALIDATE_FLOW_START_NODE_ID_IS_NULL)
    private String startNodeId;

    @NotBlank(message = ErrorCodes.INVALIDATE_FLOW_END_NODE_ID_IS_NULL)
    private String endNodeId;

    @NotBlank(message = ErrorCodes.INVALIDATE_FLOW_MODEL_ID_IS_NULL)
    private String flowModeId;

    @NotBlank(message = ErrorCodes.INVALIDATE_EDITED_BY)
    private String editedBy;
}
