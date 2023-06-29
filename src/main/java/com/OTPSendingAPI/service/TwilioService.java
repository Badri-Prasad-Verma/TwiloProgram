package com.OTPSendingAPI.service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TwilioService {
    @Value("${twilio.account.sid}")
    private String accountSid;

    @Value("${twilio.auth.token}")
    private String authToken;

    public void sendOtp(String phoneNumber, String otp) {
        Twilio.init(accountSid, authToken);

        String messageBody = "Your OTP is: " + otp;

        Message message = Message.creator(
                new PhoneNumber(phoneNumber),
                new PhoneNumber("+14302434742"),  // Replace with your Twilio phone number
                messageBody
        ).create();

        System.out.println("OTP sent to " + phoneNumber);
    }
}

