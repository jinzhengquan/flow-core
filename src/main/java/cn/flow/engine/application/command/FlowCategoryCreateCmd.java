package cn.flow.engine.application.command;

import cn.flow.core.common.Constants;
import cn.flow.core.common.ErrorCodes;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class FlowCategoryCreateCmd {

    @NotBlank(message = ErrorCodes.INVALIDATE_FLOW_CATEGORY_NAME_IS_NULL)
    @Size(max = Constants.STRING_LENGTH, message = ErrorCodes.INVALIDATE_FLOW_CATEGORY_NAME_LENGTH_LESS_100)
    private String categoryName;

    private String parentId;

    @NotBlank(message = ErrorCodes.INVALIDATE_CREATE_BY)
    private String createdBy;
}
