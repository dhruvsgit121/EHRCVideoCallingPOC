package com.EHRC.VideoCalling.Service;

import com.twilio.Twilio;
import com.twilio.exception.ApiException;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.stereotype.Service;

@Service
public class SmsService {

    //    @Value("${twilio.account.sid}")
    private String accountSid = "AC4796e133a1a0928c533fb480d92ef25b";

    //    @Value("${twilio.auth.token}")
    private String authToken = "0c67e870edd90acb822949457821b28a";

    //    @Value("${twilio.phone.number}")
    private String twilioPhoneNumber = "+18576885813";


    public SmsService() {

        System.out.println("Account SID: " + accountSid);
        System.out.println("Auth Token: " + authToken);

        if (accountSid == null || authToken == null || twilioPhoneNumber == null) {
            throw new IllegalStateException("Twilio credentials are not configured properly");
        }

        try {
            Twilio.init(accountSid, authToken);
        } catch (ApiException e) {
            System.err.println("Twilio API Error: " + e.getMessage());
            e.printStackTrace();
        }
    }


    public void sendTestSms(String toPhoneNumber, String textBody) {
        System.out.println("message send to : " + toPhoneNumber + " with text : " + textBody);
        Message.creator(
                new PhoneNumber(toPhoneNumber),
                new PhoneNumber(twilioPhoneNumber),
                textBody
        ).create();
        System.out.println("SMS Send to the user...");
    }
}
