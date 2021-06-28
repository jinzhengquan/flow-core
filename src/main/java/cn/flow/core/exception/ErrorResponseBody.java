package cn.flow.core.exception;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponseBody {
    String errorCode;
    String errorMessage;
}
