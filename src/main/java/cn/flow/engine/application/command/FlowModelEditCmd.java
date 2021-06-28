package cn.flow.engine.application.command;

import lombok.Data;
import cn.flow.core.common.Constants;
import cn.flow.core.common.ErrorCodes;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class FlowModelEditCmd {
    @NotBlank(message = ErrorCodes.INVALIDATE_FLOW_MODEL_ID_IS_NULL)
    private String id;

    @NotBlank(message = ErrorCodes.INVALIDATE_FLOW_MODEL_NAME_IS_NULL)
    @Size(max = Constants.STRING_LENGTH, message = ErrorCodes.INVALIDATE_FLOW_MODEL_NAME_LENGTH_LESS_100)
    private String flowModelName;

    @NotBlank(message = ErrorCodes.INVALIDATE_FLOW_CATEGORY_ID_IS_NULL)
    private String flowCategoryId;

    @NotBlank(message = ErrorCodes.INVALIDATE_EDITED_BY)
    private String editedBy;
}
