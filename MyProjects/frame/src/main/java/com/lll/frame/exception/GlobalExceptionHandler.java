package com.lll.frame.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public BaseResult exceptionHandler(HttpServletRequest request, Exception e) {
        e.printStackTrace();
        if (e instanceof FrameException) {
            FrameException ae = (FrameException) e;
            return BaseResult.getFail(ae.getCode(), ae.getMsg());
        } else {
            return BaseResult.getFail(BaseCode.HTTP500);
        }
    }



}
