package com.dazhenyun.conch.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@Data
@NoArgsConstructor
public class DingLinkDTO extends DingBaseDTO {

    private HashMap link;

    @Builder
    public DingLinkDTO(String messageUrl, String picUrl, String title, String text) {
        this.msgtype = "link";
        this.link = new HashMap();
        link.put("messageUrl", messageUrl);
        link.put("picUrl", picUrl);
        link.put("title", title);
        link.put("text", text);
    }
}
