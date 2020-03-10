package com.dazhenyun.conch.service.impl;

import com.dazhenyun.conch.dto.*;
import com.dazhenyun.conch.service.NoticeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class NoticeServiceImpl implements NoticeService {

    @Value("${spring.mail.username}")
    private String from;

    @Value("${spring.mail.cc}")
    private String cc;

    @Autowired
    MailSender mailSender;

    @Override
    public boolean dingNotice(DingDTO dto) {
        String content = dto.getContent();
        DingTextDTO textDTO = DingTextDTO.builder().content(content).atAll(false).mobiles(dto.getMobiles()).build();
        String DING_API = "https://oapi.dingtalk.com/robot/send?access_token=";
        String webHook_token = DING_API + dto.getAccess_token();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<DingTextDTO> resp = restTemplate.postForEntity(webHook_token, textDTO, DingTextDTO.class);
        if (resp.getStatusCode() == HttpStatus.OK) {
            return true;
        } else {
            log.error(resp.toString());
            return false;
        }
    }

    @Override
    public boolean mail(MailDTO dto) {
        boolean isSucc = false;
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(dto.getTo().split(","));
        msg.setFrom(from);
        msg.setCc(cc);
        BeanUtils.copyProperties(dto, msg);
        try {
            mailSender.send(msg);
            isSucc = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isSucc;
    }
}
