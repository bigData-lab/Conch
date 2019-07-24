package com.dazhenyun.conch.service;

import com.dazhenyun.conch.dto.DingDTO;
import com.dazhenyun.conch.dto.MailDTO;


public interface NoticeService {

    boolean dingNotice(DingDTO dto);

    boolean mail(MailDTO dto);
}
