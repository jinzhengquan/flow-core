package cn.flow.engine.exception;

import cn.flow.core.exception.DomainException;
import cn.flow.core.common.ErrorCodes;

public class FlowSubCategoryExistNotDeleteException extends DomainException {
    public FlowSubCategoryExistNotDeleteException() {
        super(ErrorCodes.FLOW_SUB_CATEGORY_EXIST_NOT_DELETE);
    }
}
