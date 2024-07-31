package com.EHRC.VideoCalling.Controller;

import com.EHRC.VideoCalling.CustomExceptions.CustomValidationException;
import com.EHRC.VideoCalling.Models.CreateRoomRequestModel;
import com.EHRC.VideoCalling.Models.User;
import com.EHRC.VideoCalling.Service.UserService;
import com.EHRC.VideoCalling.Utilities.UserUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/videocalling")

public class RoomController {

    private UserUtilities userUtilities = new UserUtilities();

    @Autowired
    private UserService userService;


    @PostMapping("/createroom")
    public ResponseEntity<String> createRoom(@RequestBody CreateRoomRequestModel requestModel) {

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





//        System.out.println("user doctor data is : " + doctorDetails.getName() + doctorDetails.getId() + doctorDetails.getRole() + doctorDetails.getContactNumber());
//
//        System.out.println("user doctor data is : " + patientDetails.getName() + patientDetails.getId() + patientDetails.getRole() + patientDetails.getContactNumber());
//
        return ResponseEntity.ok(userUtilities.getWelcomeMessage());
    }
}
