package cn.flow.engine.application.command;

import lombok.Data;
import cn.flow.core.common.ErrorCodes;

import javax.validation.constraints.NotBlank;

@Data
public class FlowNodeLinkedDeleteCmd {
    @NotBlank(message = ErrorCodes.INVALIDATE_FLOW_NODE_LINKED_ID_IS_NULL)
    private String id;

    @NotBlank(message = ErrorCodes.INVALIDATE_EDITED_BY)
    private String editedBy;
}
