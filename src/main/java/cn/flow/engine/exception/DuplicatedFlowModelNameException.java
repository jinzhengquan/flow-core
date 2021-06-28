package cn.flow.engine.exception;

import cn.flow.core.exception.DomainException;
import cn.flow.core.common.ErrorCodes;

import java.util.Arrays;

public class DuplicatedFlowModelNameException extends DomainException {
    public DuplicatedFlowModelNameException(String flowModelName) {
        super(ErrorCodes.DUPLICATED_FLOW_MODEL_NAME, Arrays.asList(flowModelName));
    }
}
