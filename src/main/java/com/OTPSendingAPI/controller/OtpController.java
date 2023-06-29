package com.OTPSendingAPI.controller;

import com.OTPSendingAPI.request.OtpRequest;
import com.OTPSendingAPI.service.TwilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class OtpController {
    private final TwilioService twilioService;

    @Autowired
    public OtpController(TwilioService twilioService) {
        this.twilioService = twilioService;
    }

    @PostMapping("/send-otp")
    public void sendOtp(@RequestBody OtpRequest otpRequest) {
        String phoneNumber = otpRequest.getPhoneNumber();
        String otp = generateOtp();  // Implement your own OTP generation logic

        // Save the generated OTP for verification in the future

        twilioService.sendOtp(phoneNumber, otp);
    }
    private String generateOtp() {
        // Implement your own OTP generation logic here
        // For example, you can generate a random 6-digit OTP
        Random random = new Random();
        int otpNumber = 100000 + random.nextInt(900000);
        return String.valueOf(otpNumber);
    }

}

