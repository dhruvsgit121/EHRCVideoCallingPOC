package com.EHRC.VideoCalling.Service;


import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;


//import java.io.UnsupportedEncodingException;
//import java.net.URLEncoder;
//import java.net.http.HttpHeaders;
////import java.nio.charset.StandardCharsets;

@Service
public class RebrandlyUrlShortenerService {

    @Value("${rebrandly.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate;

    public RebrandlyUrlShortenerService() {
        this.restTemplate = new RestTemplate();
    }

    public String shortenUrl(String longUrl) {
        String url = "https://api.rebrandly.com/v1/links";

        HttpHeaders headers = new HttpHeaders();
        headers.set("apikey", apiKey);
        headers.set("Content-Type", "application/json");

        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("destination", longUrl);

        HttpEntity<Map<String, String>> requestEntity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<Map> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, Map.class);

        Map<String, Object> responseBody = response.getBody();
        if (responseBody != null) {
            return (String) responseBody.get("shortUrl");
        } else {
            throw new RuntimeException("Failed to shorten URL");
        }
    }



//    private final RestTemplate restTemplate;
//
//    public TinyUrlService() {
//        this.restTemplate = new RestTemplate();
//    }
//
//
//    public String shortenUrl(String longUrl) {
//
//        System.out.println("entered in this 1");
//
//        try {
//
//            System.out.println("entered in this 2");
//            // URL encode the long URL
//            String encodedUrl = URLEncoder.encode(longUrl, StandardCharsets.UTF_8.toString());
//            String requestUrl = String.format("http://tinyurl.com/api-create.php?url=%s", encodedUrl);
//
//            System.out.println("entered in this 3");
//            System.out.println("url hit is " + requestUrl);
//            // Make the API call
//            String shortUrl = restTemplate.getForObject(requestUrl, String.class);
////            System.out.println("url hit is " + requestUrl);
//            System.out.println("entered in this 4");
//            // Return the shortened URL
//            return shortUrl;
//        } catch (UnsupportedEncodingException e) {
//            System.out.println("exception handled is = " + e.getLocalizedMessage());
//            throw new RuntimeException("Error encoding URL", e);
//        }
//    }

//    public String shortenUrl(String longUrl) {
////        String url = "https://api.tinyurl.com/v1/shorten"; // TinyURL API endpoint
////
////        String requestUrl = String.format("%s?url=%s", url, longUrl);
//
//        String requestUrl = String.format("http://tinyurl.com/api-create.php?url=%s", longUrl);
//
//        System.out.println("request url " + requestUrl);
//
//        // Make the API call
//        String shortUrl = restTemplate.getForObject(requestUrl, String.class);
//
//        // Make the API call
//        String response = restTemplate.getForObject(requestUrl, String.class);
//
//        // Extract shortened URL from response (modify as needed based on actual response format)
//        return response; // Assuming response directly contains the shortened URL
//    }



}
