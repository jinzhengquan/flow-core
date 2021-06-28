package cn.flow.core.annotation;

import cn.flow.core.exception.ExceptionHandlerController;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(ExceptionHandlerController.class)
public @interface EnableGlobalExceptionHandler {
}
