package com.dazhenyun.conch.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DingDTO {


    @ApiModelProperty(value = "钉钉群自定义机器人的token", required = true)
    private String access_token;

    @ApiModelProperty(value = "消息内容", required = true)
    private String content;
}
