package com.student.studentdirectory.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "students")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    //@Column(name = "id")
    //private long id;

    //@Column(name = "address")
    //private String address;

    //@Column(name = "phone_number")
    //private String phoneNumber;

    @Id
    @Column(name = "Survey_Id")
    private int surveyId;

    @Column(name = "First_Name")
    private String firstName;

    @Column(name = "Last_Name")
    private String lastName;

    @Column(name = "Address")
    private String address;

    @Column(name = "City")
    private String city;

    @Column(name = "Zip")
    private int zip;

    @Column(name = "Phone_Number")
    private long phoneNumber;

    @Column(name = "Survey_Date")
    private String surveyDate;

    @Column(name = "Thing_Liked_On_Campus")
    private String campusLovedThing;

    @Column(name = "What_Intrested_On_University")
    private String whyJoinUni;

    @Column(name = "Recommendation_To_Friend")
    private String recommendFriends;

}
