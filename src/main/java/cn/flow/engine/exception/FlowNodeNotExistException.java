package cn.flow.engine.exception;

import cn.flow.core.exception.DomainException;
import cn.flow.core.common.ErrorCodes;

import java.util.Arrays;

public class FlowNodeNotExistException extends DomainException {
    public FlowNodeNotExistException(String message) {
        super(ErrorCodes.FLOW_NODE_ID_NOT_EXIST, Arrays.asList(message));
    }
}
