package cn.flow.core.exception;

import java.util.Collections;
import java.util.List;

public abstract class DomainException extends RuntimeException {
    public String errorCode;
    public List<String> params;

    public DomainException(String errorCode, List<String> params) {
        this.errorCode = errorCode;
        this.params = params;
    }

    protected DomainException(String errorCode) {
        this(errorCode, Collections.emptyList());
    }

    public DomainException(String errorCode, Throwable cause) {
        super(errorCode, cause);
    }
}
