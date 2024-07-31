package com.EHRC.VideoCalling.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class RoomModel {

    private String id;
    private String name;
    private Date creationDate;
    private Date expiryDate;
    private Date callEndTime;
    private Date callStartTime;




}
