package com.wyq.firstdemo.handler;

import com.wyq.firstdemo.common.ServerResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Set;

@Slf4j
@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler
    @ResponseBody
    public ServerResponse<String> handle(ConstraintViolationException exception) {
        log.error(String.valueOf(exception));
        Set<ConstraintViolation<?>> violations = exception.getConstraintViolations();
        StringBuilder builder = new StringBuilder();
        for (ConstraintViolation violation : violations) {
            builder.append(violation.getMessage());
            break;
        }
        return ServerResponse.createByErrorMessage(builder.toString());
    }

    @ExceptionHandler
    @ResponseBody
    public ServerResponse<String> handle(MethodArgumentNotValidException exception) {
        log.error(String.valueOf(exception));
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        String firstMessage = fieldErrors.get(0).getDefaultMessage();
        return ServerResponse.createByErrorMessage(firstMessage);
    }

}
