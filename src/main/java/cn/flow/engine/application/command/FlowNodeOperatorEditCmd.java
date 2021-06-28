package cn.flow.engine.application.command;

import lombok.Data;
import cn.flow.core.common.ErrorCodes;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
public class FlowNodeOperatorEditCmd {
    @NotBlank(message = ErrorCodes.INVALIDATE_FLOW_NODE_OPERATOR_ID_IS_NULL)
    private String id;

    @NotBlank(message = ErrorCodes.INVALIDATE_FLOW_MODEL_ID_IS_NULL)
    private String flowModelId;

    @NotBlank(message = ErrorCodes.INVALIDATE_FLOW_NODE_ID_IS_NULL)
    private String flowNodeId;

    private List<String> operator;

    private List<String> role;

    @NotBlank(message = ErrorCodes.INVALIDATE_EDITED_BY)
    private String editedBy;

}
