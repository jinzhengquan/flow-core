package cn.flow.engine.exception;

import cn.flow.core.exception.DomainException;
import cn.flow.core.common.ErrorCodes;

import java.util.Arrays;

public class DuplicatedFlowCategoryNameException extends DomainException {
    public DuplicatedFlowCategoryNameException(String categoryName) {
        super(ErrorCodes.DUPLICATED_FLOW_CATEGORY_NAME, Arrays.asList(categoryName));
    }
}
