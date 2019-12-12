package com.example.kaistcampusv2;
import android.graphics.Bitmap;

import java.util.ArrayList;

enum Day {
    WEEKDAYS,
    SATURDAY,
    SUNDAY
}

public class Facility {
    private int id;
    private String name;
    private Bitmap image;
    private String description;
    private ArrayList<Day> businessDays;
    private String businessHours;
    private String contactInfo;
    private boolean isOnCampus;

    Facility(int id, String name, String description, boolean isOnCampus, String[] businessDays, String businessHours, String contactInfo) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.isOnCampus = isOnCampus;
        this.businessDays = new ArrayList<>();
        this.businessHours = businessHours;
        this.contactInfo = contactInfo;

        for(int i = 0; i < businessDays.length; i++)
        {
            this.businessDays.add(Day.valueOf(businessDays[i]));
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public boolean isOnCampus() {
        return isOnCampus;
    }

    String getBusinessDays(){
        switch (businessDays.size()){
            case 1:
                return "Monday-Friday";
            case 2:
                return "Monday-Friday, Saturday";
            case 3:
                return "Everyday";
            default:
                return "";
        }
    }

    public void setBusinessDays(ArrayList<Day> businessDays) {
        this.businessDays = businessDays;
    }

    public String getBusinessHours() {
        return businessHours;
    }

    public void setBusinessHours(String businessHours) {
        this.businessHours = businessHours;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    @Override
    public String toString() {
        return id + ": " + name + "\n" + description + "\n" +
                getBusinessDays() + "\n" + businessHours;
    }
}