package org.iclass.mvc.controller;

import org.iclass.mvc.service.RegisterMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@org.springframework.web.bind.annotation.RestController
@RequestMapping(value = "/api/mail")
public class RestController {

    @Autowired
    RegisterMail registerMail;

    
    //127.0.0.1:8080/ROOT/api/mail/confirm.json?email
    @PostMapping(value = "/confirm.json")
    public String mailConfirm(@RequestParam(name = "email") String email) throws Exception{
        String code = registerMail.sendSimpleMessage(email);
        System.out.println("사용자에게 발송한 인증코드 ==> " + code);

        return code;
    }
    
    
}