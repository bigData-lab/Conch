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

    @ApiModelProperty(value = "content中需要@人员的手机列表（字符串格式，英文逗号间隔）")
    private String mobiles;
}
