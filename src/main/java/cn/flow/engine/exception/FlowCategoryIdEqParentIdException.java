package cn.flow.engine.exception;

import cn.flow.core.exception.DomainException;
import cn.flow.core.common.ErrorCodes;

import java.util.Arrays;

public class FlowCategoryIdEqParentIdException extends DomainException {
    public FlowCategoryIdEqParentIdException(String message) {
        super(ErrorCodes.FLOW_CATEGORY_ID_EQ_PARENT_ID, Arrays.asList(message));
    }
}
