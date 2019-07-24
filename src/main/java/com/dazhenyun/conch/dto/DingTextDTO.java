package com.dazhenyun.conch.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
public class DingTextDTO extends DingBaseDTO{

    private Map text;
    private Map at;

    @Builder
    public DingTextDTO(String content, Boolean atAll, String mobiles) {

        msgtype = "text";
        text = new HashMap();
        Map cxt = new HashMap();
        cxt.put("content", content);
        text = cxt;
        at = new HashMap();
        if (!StringUtils.isEmpty(mobiles)) {
            String[] mobileArray = mobiles.split(",");
            HashMap atMap = new HashMap();
            atMap.put("atMobiles", mobileArray);
            atMap.put("isAtAll", atAll);
            at = atMap;
        }
    }
}
