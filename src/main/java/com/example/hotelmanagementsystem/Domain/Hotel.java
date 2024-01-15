package com.example.hotelmanagementsystem.Domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name="Hotel")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String applicantName;
    private String applicantGender;
    private Long applicantContact;
    private String stay_Duration;
    private String stayPurpose;
    private int guestNum;
    private String roomName;

    public Hotel(){

    }
    // Getter and Setter


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public String getApplicantGender() {
        return applicantGender;
    }

    public void setApplicantGender(String applicantGender) {
        this.applicantGender = applicantGender;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Long getApplicantContact() {
        return applicantContact;
    }

    public void setApplicantContact(Long applicantContact) {
        this.applicantContact = applicantContact;
    }

    public String getStay_Duration() {
        return stay_Duration;
    }

    public void setStay_Duration(String stay_Duration) {
        this.stay_Duration = stay_Duration;
    }

    public String getStayPurpose() {
        return stayPurpose;
    }


    public void setStayPurpose(String stayPurpose) {
        this.stayPurpose = stayPurpose;
    }


    public int getGuestNum() {
        return guestNum;
    }

    public void setGuestNum(int guestNum) {
        this.guestNum = guestNum;
    }

    public Hotel(Long id, String applicantName, String applicantGender,String roomName, Long applicantContact, String stay_Duration, String stayPurpose, int guestNum) {
        this.id = id;
        this.roomName=roomName;
        this.applicantName = applicantName;
        this.applicantGender = applicantGender;
        this.applicantContact = applicantContact;
        this.stayPurpose = stayPurpose;
        this.guestNum = guestNum;
        this.stay_Duration = stay_Duration;

    }
}
