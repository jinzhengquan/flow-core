package cn.flow.engine.exception;

import cn.flow.core.exception.DomainException;
import cn.flow.core.common.ErrorCodes;

import java.util.Arrays;

public class FlowNodeOperatorNotExistException extends DomainException {
    public FlowNodeOperatorNotExistException(String message) {
        super(ErrorCodes.FLOW_NODE_OPERATOR_ID_NOT_EXIST, Arrays.asList(message));
    }
}
