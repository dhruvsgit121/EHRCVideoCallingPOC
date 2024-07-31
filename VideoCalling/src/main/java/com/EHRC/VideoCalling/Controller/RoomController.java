package com.EHRC.VideoCalling.Controller;

import com.EHRC.VideoCalling.CustomExceptions.CustomValidationException;
import com.EHRC.VideoCalling.Models.CreateRoomRequestModel;
import com.EHRC.VideoCalling.Models.User;
import com.EHRC.VideoCalling.Service.JWTTokenService;
import com.EHRC.VideoCalling.Service.UserService;
import com.EHRC.VideoCalling.Utilities.UserUtilities;
import com.fasterxml.jackson.core.PrettyPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping("/videocalling")

public class RoomController {

    private UserUtilities userUtilities = new UserUtilities();

    @Autowired
    private UserService userService;

    @Autowired
    private JWTTokenService jwtTokenService;


    @PostMapping("/createroom")
    public ResponseEntity<?> createRoom(@RequestBody CreateRoomRequestModel requestModel) {

        System.out.println("createRoom called doctor ID: " + requestModel.doctorID + " Patient ID : " + requestModel.patientID);

        Optional<User> doctorUserDetails = userService.getDoctorDetails(requestModel.doctorID);
        Optional<User> patientUserDetails = userService.getPatientDetails(requestModel.patientID);


        User doctorDetails, patientDetails;

        System.out.println("line called");

        if (doctorUserDetails.isPresent()) {
            doctorDetails = doctorUserDetails.get();
        } else {
            throw new CustomValidationException("No Doctor exists with this ID.");
        }

        if (patientUserDetails.isPresent()) {
            patientDetails = patientUserDetails.get();
        } else {
            throw new CustomValidationException("No Patient exists with this ID.");
        }

        String emailPrefix = "@gmail.com";

        String doctorEmail =  doctorDetails.getName() + emailPrefix;
        String patientEmail =  patientDetails.getName() + emailPrefix;

        Map<String, Object> userTokenData = jwtTokenService.generateUserJWTTokenData(doctorDetails.getName(), doctorEmail, patientDetails.getName(), patientEmail);
        Map<String, Object> response = new HashMap<>();
        response.putAll(userTokenData);
        response.put("timestamp", LocalDateTime.now());

        return ResponseEntity.ok(response);

    }
}
