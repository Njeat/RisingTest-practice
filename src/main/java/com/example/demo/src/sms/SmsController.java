package com.example.demo.src.sms;

import com.example.demo.config.BaseException;
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

    @ResponseBody
    @PostMapping("/{phoneNum}")
    public void sendMessage(@PathVariable("phoneNum") String phoneNum){
        smsService.sendMessage(phoneNum);
    }

    @ResponseBody
    @PostMapping("/certification/{randomNum}")
    public void certificationNum(@PathVariable("randomNum") String randomNum) throws BaseException {
        smsService.certificationNum(randomNum);
    }
}
