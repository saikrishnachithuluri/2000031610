package com.klef.jfsd.springbootingboot;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;



@Service
public class TrainServiceImpl implements TrainService {
    private static final String AUTH_TOKEN = "Bearer eyJhbGci0iJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE20DI2MjkyNjQsImNvbXBhbn10YW1lIjoiVHJhaW4gQ2VudHJhbCIsImNsaWVudElEIjoiYjQ2MTE4ZjAtZmJkZSO0YjE2LWEOYjEtNmF1NmFkNzE4YjI3In0.v93QcxrZHWDTnTwm0-6ttoTGI4C64Grhn7rIJDC8fy8";

    @Override
    public List<Train> getAllTrains() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", AUTH_TOKEN);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<Train[]> response = restTemplate.exchange("http://104.211.219.98/train/trains", HttpMethod.GET, entity, Train[].class);
        Train[] trains = response.getBody();
        return trains != null ? Arrays.asList(trains) : Collections.emptyList();
    }

    @Override
    public Train getTrainByNumber(String trainNumber) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", AUTH_TOKEN);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<Train> response = restTemplate.exchange("http://104.211.219.98/train/trains/" + trainNumber, HttpMethod.GET, entity, Train.class);
        return response.getBody();
    }
}
