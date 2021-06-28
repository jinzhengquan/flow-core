package cn.flow.engine.exception;

import cn.flow.core.exception.DomainException;
import cn.flow.core.common.ErrorCodes;

public class DuplicatedStartFlowNodeException extends DomainException {
    public DuplicatedStartFlowNodeException() {
        super(ErrorCodes.DUPLICATED_START_FLOW_NODE);
    }
}
