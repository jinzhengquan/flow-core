package cn.flow.engine.exception;

import cn.flow.core.exception.DomainException;
import cn.flow.core.common.ErrorCodes;

import java.util.Arrays;

public class FlowDeployNodeNotExistStartNodeException extends DomainException {
    public FlowDeployNodeNotExistStartNodeException(String message) {
        super(ErrorCodes.FLOW_DEPLOY_START_NODE_ID_NOT_EXIST, Arrays.asList(message));
    }
}
