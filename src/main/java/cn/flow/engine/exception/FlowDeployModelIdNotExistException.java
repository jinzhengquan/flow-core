package cn.flow.engine.exception;

import cn.flow.core.exception.DomainException;
import cn.flow.core.common.ErrorCodes;

import java.util.Arrays;

public class FlowDeployModelIdNotExistException extends DomainException {
    public FlowDeployModelIdNotExistException(String message) {
        super(ErrorCodes.FLOW_DEPLOY_MODEL_ID_NOT_EXIST, Arrays.asList(message));
    }
}
