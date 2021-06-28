package cn.flow.engine.application.command;

import lombok.Data;
import cn.flow.core.common.Regex;
import cn.flow.core.common.Constants;
import cn.flow.core.common.ErrorCodes;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class FlowNodeCreateCmd {

    @NotBlank(message = ErrorCodes.INVALIDATE_FLOW_NODE_NAME_IS_NULL)
    @Size(max = Constants.STRING_LENGTH, message = ErrorCodes.INVALIDATE_FLOW_NODE_NAME_LENGTH_LESS_100)
    private String nodeName;

    @Pattern(regexp = Regex.NODE_TYPE, message = ErrorCodes.INVALIDATE_FLOW_NODE_TYPE_ERROR)
    private String nodeType;

    private String operatorStrategy;

    @NotBlank(message = ErrorCodes.INVALIDATE_FLOW_MODEL_ID_IS_NULL)
    private String flowModelId;

    @NotBlank(message = ErrorCodes.INVALIDATE_CREATE_BY)
    private String createdBy;
}
