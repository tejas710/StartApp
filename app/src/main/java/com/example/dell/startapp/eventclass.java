package com.example.dell.startapp;

/**
 * Created by DELL on 29-10-2016.
 */

public class eventclass {
    private String eventName;
    private String startTime;
    private String endTime;
    private String startDate;
    private String eventDescription;
    private String endDate;
    private String venue;
    private String isVideoSession;

    public eventclass(String eventName, String startTime, String endTime, String startDate, String eventDescription, String endDate, String venue, String isVideoSession) {
        this.eventName = eventName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.startDate = startDate;
        this.eventDescription = eventDescription;
        this.endDate = endDate;
        this.venue = venue;
        this.isVideoSession = isVideoSession;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getIsVideoSession() {
        return isVideoSession;
    }

    public void setIsVideoSession(String isVideoSession) {
        this.isVideoSession = isVideoSession;
    }
}
