package cn.flow.core.exception;

import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import java.util.Locale;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.ResponseEntity.badRequest;

@SuppressWarnings("ClassCanBeRecord")
@ControllerAdvice
public class ExceptionHandlerController {

    private final MessageSource messageSource;

    public ExceptionHandlerController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(DomainException.class)
    @ResponseStatus(BAD_REQUEST)
    public ResponseEntity<ErrorResponseBody> domainExceptionHandler(DomainException exception, WebRequest request) {
        ErrorResponseBody errorResponseBody = new ErrorResponseBody(exception.errorCode, getMessage(exception, request.getLocale()));
        return badRequest().body(errorResponseBody);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(BAD_REQUEST)
    public ResponseEntity<ErrorResponseBody> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException exception, WebRequest request) {
        Locale locale = request.getLocale();
        FieldError fieldError = exception.getBindingResult().getFieldError();
        if (fieldError == null) return buildUnknownErrorResponse(locale);
        String errorCode = fieldError.getDefaultMessage();
        if (errorCode == null || errorCode.isEmpty()) return buildUnknownErrorResponse(locale);
        Object rejectedValue = fieldError.getRejectedValue();
        String errorMessage = messageSource.getMessage(errorCode, new Object[] { rejectedValue }, locale);
        ErrorResponseBody errorResponseBody = new ErrorResponseBody(errorCode, errorMessage);
        return badRequest().body(errorResponseBody);
    }

    private ResponseEntity<ErrorResponseBody> buildUnknownErrorResponse(Locale locale) {
        return badRequest().body(new ErrorResponseBody(ErrorCodes.UNKNOWN, messageSource.getMessage(ErrorCodes.UNKNOWN, null, locale)));
    }

    private String getMessage(DomainException exception, Locale locale) {
        return messageSource.getMessage(exception.errorCode, exception.params.toArray(), locale);
    }
}
