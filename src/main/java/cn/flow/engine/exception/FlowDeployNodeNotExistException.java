package cn.flow.engine.exception;

import cn.flow.core.common.ErrorCodes;
import cn.flow.core.exception.DomainException;

import java.util.Arrays;

public class FlowDeployNodeNotExistException extends DomainException {
    public FlowDeployNodeNotExistException(String message) {
        super(ErrorCodes.FLOW_DEPLOY_NODE_ID_NOT_EXIST, Arrays.asList(message));
    }
}
