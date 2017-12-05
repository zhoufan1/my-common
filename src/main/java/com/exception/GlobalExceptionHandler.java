package com.exception;

import com.domain.base.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public Response<?> handleBaseException(BusinessException e) {
        log.error("BaseException ", e);
        return Response.failed(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Response<?> handleException(Exception e) {
        log.error("Exception ", e);
        return Response.systemError(e.getMessage());
    }

}
