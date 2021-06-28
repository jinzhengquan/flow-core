package cn.flow.engine.exception;

import cn.flow.core.exception.DomainException;
import cn.flow.core.common.ErrorCodes;

import java.util.Arrays;

public class FlowNodeOperatorNotNullException extends DomainException {
    public FlowNodeOperatorNotNullException(String instanceId, String nodeId) {
        super(ErrorCodes.FLOW_NODE_OPERATOR_IS_NOT_NULL, Arrays.asList(instanceId, nodeId));
    }
}
