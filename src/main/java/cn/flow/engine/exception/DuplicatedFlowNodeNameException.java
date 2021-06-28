package cn.flow.engine.exception;

import cn.flow.core.exception.DomainException;
import cn.flow.core.common.ErrorCodes;

import java.util.Arrays;

public class DuplicatedFlowNodeNameException extends DomainException {
    public DuplicatedFlowNodeNameException(String flowNodeName) {
        super(ErrorCodes.DUPLICATED_FLOW_NODE_NAME, Arrays.asList(flowNodeName));
    }
}
