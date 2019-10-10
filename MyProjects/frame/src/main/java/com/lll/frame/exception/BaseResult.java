package com.lll.frame.exception;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResult<T> {
    private int code = 200;
    private String message = "";
    private T data;

    private void Result() {

    }


    public static BaseResult getSuccess(Object info, String message) {
        BaseResult r = new BaseResult();
        r.setCode(0);
        r.message = message;
        r.setData(info);
        return r;
    }

    public static BaseResult getFail(int code, String message) {
        BaseResult r = new BaseResult();
        r.setCode(code);
        r.setMessage(message);
        return r;
    }

    public static BaseResult getFail(BaseCode code) {
        BaseResult r = new BaseResult();
        r.setMessage(code.getMsg());
        r.setCode(code.getCode());
        return r;
    }
}
