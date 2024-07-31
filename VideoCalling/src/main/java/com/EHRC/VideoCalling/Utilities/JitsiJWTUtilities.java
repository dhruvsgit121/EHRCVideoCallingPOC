package com.EHRC.VideoCalling.Utilities;

import org.apache.commons.lang3.RandomStringUtils;
import java.time.Instant;


public class JitsiJWTUtilities {


    public static long getExpirationTimeStamp(int timeStampOffset) {
        return Instant.now().plusSeconds(timeStampOffset).getEpochSecond();
    }

    public static long getCurrentTimeStamp() {
        return Instant.now().getEpochSecond();
    }

    public static String generateRandomString(int stringLength) {
        boolean useLetters = true;
        boolean useNumbers = true;
        String generatedString = RandomStringUtils.random(stringLength, useLetters, useNumbers);
        return generatedString;
    }


}
