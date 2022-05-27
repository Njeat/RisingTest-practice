package com.example.demo.src.sms;

import com.example.demo.config.secret.Secret;
import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
import org.json.simple.JSONObject; // JSON객체 생성
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Random;

@Service
public class SmsService {

    public void sendMessage(String toNumber) {
        String api_key = Secret.SMS_API_KEY;
        String api_secret = Secret.SMS_API_SECRET_KEY;

        Message coolsms = new Message(api_key, api_secret);

        String randomNumber = "";
        Random rand  = new Random();
        for(int i = 0; i < 6; i++) {
            String ran = Integer.toString(rand.nextInt(10));
            randomNumber += ran;
        }

        HashMap<String, String> params = new HashMap<String, String>();

        params.put("to", toNumber);
        params.put("from", Secret.FROM_NUMBER);
        params.put("type", "SMS");
        params.put("text", "[grabMe] 인증번호 " + randomNumber + " 를 입력하세요.");
        params.put("app_version", "test app 1.2"); // application name and version

        try {
            JSONObject obj = (JSONObject) coolsms.send(params);
            System.out.println(obj.toString());
        } catch (CoolsmsException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCode());
        }
    }
}
