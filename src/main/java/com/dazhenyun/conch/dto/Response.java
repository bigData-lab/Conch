package com.dazhenyun.conch.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by wangww on 2019.1.2.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response<T> implements Serializable {

  private static final long serialVersionUID = -1222614520893986846L;

  private T result;

  /**
   * 请求回传code
   */
  private Integer code;

  /**
   * 请求处理结果描述
   */
  private String msg;
}
