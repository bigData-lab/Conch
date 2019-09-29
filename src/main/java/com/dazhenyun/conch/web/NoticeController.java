package com.dazhenyun.conch.web;

import com.dazhenyun.conch.dto.*;
import com.dazhenyun.conch.service.NoticeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Api("conch")
@Slf4j
@RestController
@RequestMapping("/conch")
public class NoticeController {


    @Autowired
    NoticeService noticeService;

    @Value("${aaa.bbb.ccc}")
    private String ccc;

    @ApiOperation("钉钉通知API ")
    @PostMapping(value = "/notice/ding")
    public Response ding(@RequestBody DingDTO dto) {
        Response resp = new Response("err", 500, "err");
        if (noticeService.dingNotice(dto)) {
            resp = new Response("success", 200, "success");
        }
        return resp;
    }

    @ApiOperation("邮件通知API ")
    @PostMapping(value = "/notice/mail")
    public Response mail(@RequestBody MailDTO dto) {
        Response resp = new Response("err", 500, "err");
        if (noticeService.mail(dto)) {
            resp = new Response("success", 200, "success");
        }
        return resp;
    }

    @ApiOperation("testAPI ")
    @GetMapping(value = "/notice/test")
    public Response mail() {

        return new Response("sucess", 200, ccc);
    }


}
