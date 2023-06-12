package com.dp.springboot;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/train")
public class TrainController {

    private final RegistrationResponseRepository registrationResponseRepository;
    private final AuthorizationRequestRepository authorizationRequestRepository;
    private final AuthorizationResponseRepository authorizationResponseRepository;

    public TrainController(RegistrationResponseRepository registrationResponseRepository,
                           AuthorizationRequestRepository authorizationRequestRepository,
                           AuthorizationResponseRepository authorizationResponseRepository) {
        this.registrationResponseRepository = registrationResponseRepository;
        this.authorizationRequestRepository = authorizationRequestRepository;
        this.authorizationResponseRepository = authorizationResponseRepository;
    }

    @PostMapping("/register")
    public ResponseEntity<RegistrationResponse> registerCompany(@RequestBody RegistrationRequest request) {
        RegistrationResponse response = new RegistrationResponse();
        response.setCompanyName(request.getCompanyName());
        response.setClientID("b46118f0-fbde-4b16-a4b1-6ae6ad718b27");
        response.setClientSecret("XOyolORPasKWODAN");

        RegistrationResponse responseEntity = new RegistrationResponse();
        responseEntity.setCompanyName(response.getCompanyName());
        responseEntity.setClientID(response.getClientID());
        responseEntity.setClientSecret(response.getClientSecret());
        registrationResponseRepository.save(responseEntity);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("/auth")
    public ResponseEntity<AuthorizationResponse> authorizeCompany(@RequestBody AuthorizationRequest request) {
        AuthorizationResponse response = new AuthorizationResponse();
        response.setTokenType("Bearer");
        response.setAccessToken("eyJhbGci0iJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE20DI2MjkyNjQsImNvbXBhbn10YW1lIjoiVHJhaW4gQ2VudHJhbCIsImNsaWVudElEIjoiYjQ2MTE4ZjAtZmJkZSO0YjE2LWEOYjEtNmF1NmFkNzE4YjI3In0.v93QcxrZHWDTnTwm0-6t toTGI4C64Grhn7rIJDC8fy8");
        response.setExpiresIn((long) 1682629264);

        AuthorizationRequest requestEntity = new AuthorizationRequest();
        requestEntity.setCompanyName(request.getCompanyName());
        requestEntity.setClientID(request.getClientID());
        requestEntity.setOwnerName(request.getOwnerName());
        requestEntity.setOwnerEmail(request.getOwnerEmail());
        requestEntity.setRollNo(request.getRollNo());
        requestEntity.setClientSecret(request.getClientSecret());
        authorizationRequestRepository.save(requestEntity);

        AuthorizationResponse responseEntity = new AuthorizationResponse();
        responseEntity.setTokenType(response.getTokenType());
        responseEntity.setAccessToken(response.getAccessToken());
        responseEntity.setExpiresIn(response.getExpiresIn());
        authorizationResponseRepository.save(responseEntity);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/trains")
    public ResponseEntity<Train[]> getAllTrains(@RequestHeader("Authorization") String token) {
        Train[] trains = new Train[2];

        Train train1 = new Train();
        train1.setTrainName("Chennai Exp");
        train1.setTrainNumber("2344");

        DepartureTime departureTime1 = new DepartureTime();
        departureTime1.setHours(21);
        departureTime1.setMinutes(35);
        departureTime1.setSeconds(0);
        train1.setDepartureTime(departureTime1);

        SeatsAvailable seatsAvailable1 = new SeatsAvailable();
        seatsAvailable1.setSleeper(3);
        seatsAvailable1.setAC(1);
        train1.setSeatsAvailable(seatsAvailable1);

        Price price1 = new Price();
        price1.setSleeper(2);
        price1.setAC(5);
        train1.setPrice(price1);

        train1.setDelayedBy(15);

        trains[0] = train1;

        Train train2 = new Train();
        train2.setTrainName("Hyderabad Exp");
        train2.setTrainNumber("2341");

        DepartureTime departureTime2 = new DepartureTime();
        departureTime2.setHours(23);
        departureTime2.setMinutes(55);
        departureTime2.setSeconds(0);
        train2.setDepartureTime(departureTime2);

        SeatsAvailable seatsAvailable2 = new SeatsAvailable();
        seatsAvailable2.setSleeper(6);
        seatsAvailable2.setAC(7);
        train2.setSeatsAvailable(seatsAvailable2);

        Price price2 = new Price();
        price2.setSleeper(554);
        price2.setAC(1854);
        train2.setPrice(price2);

        train2.setDelayedBy(5);

        trains[1] = train2;

        return ResponseEntity.status(HttpStatus.OK).body(trains);
    }
}

