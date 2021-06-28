package cn.flow.core.exception;

import java.util.Arrays;
import java.util.List;

public class FlowException extends DomainException {

    private static final long serialVersionUID = 1L;

    public FlowException(String errorCode, Throwable cause) {
        super(errorCode, cause);
    }

    public FlowException(String message) {
        super(message);
    }

    public FlowException(String errorCode, List<String> params) {
        super(errorCode, params);
    }

    public FlowException(String errorCode, String errorMessage) {
        super(errorCode, Arrays.asList(errorMessage));
    }
}

