package com.lll.frame.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * ClassName FrameException
 * Description
 *
 * @Author zl
 * @Create 2019-08-12 11:09
 **/
@Data
@EqualsAndHashCode(callSuper=false)
public class FrameException extends RuntimeException {

  private Integer code;
  private String msg;
  private String detail;


  public FrameException() {};

  public FrameException(BaseCode msgCode) {
    this.code = msgCode.getCode();
    this.msg = msgCode.getMsg();
  }


}
