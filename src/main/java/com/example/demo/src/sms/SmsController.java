package com.example.demo.src.sms;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sms")
public class SmsController {

    @Autowired
    private final SmsService smsService;

    public SmsController(SmsService smsService){
        this.smsService = smsService;
    }

    @GetMapping("/certification/{phoneNum}")
    public void sendMessage(@PathVariable String phoneNum){
        smsService.sendMessage(phoneNum);
    }
}
