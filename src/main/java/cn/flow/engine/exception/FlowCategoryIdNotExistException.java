package cn.flow.engine.exception;

import cn.flow.core.exception.DomainException;
import cn.flow.core.common.ErrorCodes;

import java.util.Arrays;

public class FlowCategoryIdNotExistException extends DomainException {
    public FlowCategoryIdNotExistException(String message) {
        super(ErrorCodes.FLOW_CATEGORY_ID_NOT_EXIST, Arrays.asList(message));
    }
}
