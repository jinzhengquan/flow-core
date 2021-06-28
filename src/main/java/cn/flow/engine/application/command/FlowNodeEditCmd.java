package cn.flow.engine.application.command;

import lombok.Data;
import cn.flow.core.common.Constants;
import cn.flow.core.common.ErrorCodes;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class FlowNodeEditCmd {
    @NotBlank(message = ErrorCodes.INVALIDATE_FLOW_NODE_ID_IS_NULL)
    private String id;

    @NotBlank(message = ErrorCodes.INVALIDATE_FLOW_NODE_NAME_IS_NULL)
    @Size(max = Constants.STRING_LENGTH, message = ErrorCodes.INVALIDATE_FLOW_NODE_NAME_LENGTH_LESS_100)
    private String nodeName;

    private String operatorStrategy;

    @NotBlank(message = ErrorCodes.INVALIDATE_EDITED_BY)
    private String editedBy;
}
