package com.loskatt.appoint.common;

import org.springframework.web.bind.annotation.*;

@ControllerAdvice(annotations = RestController.class)
@ResponseBody
public class RestExceptionHandler
{
    /**
     * 默认统一异常处理方法
     * @param e 默认Exception异常对象
     * @return
     */
    @ExceptionHandler
    @ResponseStatus
    public Result runtimeExceptionHandler(GlobalException e) {
        return new Result(e.getStatusCode(),e.getMessage());
    }
}
