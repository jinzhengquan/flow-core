package cn.flow.engine.exception;

import cn.flow.core.exception.DomainException;
import cn.flow.core.common.ErrorCodes;

import java.util.Arrays;

public class FlowInstanceNotExistException extends DomainException {
    public FlowInstanceNotExistException(String message) {
        super(ErrorCodes.FLOW_TASK_ID_NOT_EXIST, Arrays.asList(message));
    }
}
