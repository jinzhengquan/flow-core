package cn.flow.engine.exception;

import cn.flow.core.exception.DomainException;
import cn.flow.core.common.ErrorCodes;

import java.util.Arrays;

public class FlowTaskNotExistException extends DomainException {
    public FlowTaskNotExistException(String message) {
        super(ErrorCodes.FLOW_TASK_ID_NOT_EXIST, Arrays.asList(message));
    }
}
