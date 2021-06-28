package cn.flow.engine.exception;

import cn.flow.core.exception.DomainException;
import cn.flow.core.common.ErrorCodes;

import java.util.Arrays;

public class FlowModelIdNotExistException extends DomainException {
    public FlowModelIdNotExistException(String message) {
        super(ErrorCodes.FLOW_MODEL_ID_NOT_EXIST, Arrays.asList(message));
    }
}
