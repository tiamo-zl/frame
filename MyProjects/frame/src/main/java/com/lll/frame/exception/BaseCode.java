package com.lll.frame.exception;

import lombok.Data;

/**
 * ClassName BaseCode
 * Description
 *
 * @Author zl
 * @Create 2019-08-12 11:09
 **/
@Data
public class BaseCode {

  private int code;
  /**
   *
   */
  private String msg;

  public static final BaseCode SUCCESS = new BaseCode(0, "ok");

  public static final BaseCode ARGUMENT_INVALID = new BaseCode(400800, "参数错误");
  public static final BaseCode REQUEST_INVALID = new BaseCode(400801, "请求错误");

  public static final BaseCode HTTP500 = new BaseCode(900500, "服务器错误");


  public BaseCode(int code, String msg) {
    this.code = code;
    this.msg = msg;
  }
}
