package cn.flow.engine.exception;

import cn.flow.core.exception.DomainException;
import cn.flow.core.common.ErrorCodes;

public class DuplicatedEndFlowNodeException extends DomainException {
    public DuplicatedEndFlowNodeException() {
        super(ErrorCodes.DUPLICATED_END_FLOW_NODE);
    }
}
