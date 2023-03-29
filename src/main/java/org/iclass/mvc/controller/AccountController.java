package org.iclass.mvc.controller;

import java.util.Map;

import org.iclass.mvc.service.EmailService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
public class AccountController {

    private final EmailService emailService;

    @GetMapping("login/mailConfirm")
    public String mailview() {
    	return "redirect:/";
    }
    
    @PostMapping("login/mailConfirm")
    @ResponseBody
    public String mailConfirm(@RequestBody Map<String, String> requestData) throws Exception {
        String email = requestData.get("email");
        String code = emailService.sendSimpleMessage(email);
        log.info("인증코드 : " + code);
        return code;
    }
}