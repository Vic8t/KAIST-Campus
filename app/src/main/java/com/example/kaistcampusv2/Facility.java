package com.example.kaistcampusv2;
import android.graphics.Bitmap;

import java.util.ArrayList;

enum Day {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;
}

public class Facility {
    private int id;
    private String name;
    private Bitmap image;
    private String description;
    private String businessHours;
    private String contactInfo;
    private ArrayList<Day> businessDays;
    private boolean isOnCampus;

    public Facility(int id, String name, String description, boolean isOnCampus, String[] businessDays, String businessHours, String contactInfo) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.isOnCampus = isOnCampus;
        this.businessDays = new ArrayList<Day>();
        this.businessHours = businessHours;
        this.contactInfo = contactInfo;

        for(int i = 0; i < businessDays.length; i++)
        {
            this.businessDays.add(Day.valueOf(businessDays[i]));
        }
    }

    public String businessDays(){
        if(businessDays.size() == 7){
            return "EVERYDAY";
        }
        else if(businessDays.size() == 6 && !businessDays.contains(Day.SUNDAY)){
            return "MONDAY~FRIDAY, SATURDAY";
        }
        else if(businessDays.size() == 5 && !businessDays.contains(Day.SATURDAY) && !businessDays.contains(Day.SUNDAY)){
            return "MONDAY~FRIDAY";
        }
        else {
            String days = "";
            for(int i = 0; i < businessDays.size(); i++){
                days += businessDays.get(i);
                if(i != businessDays.size() - 1){
                    days += ", ";
                }
            }
            return days;
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

    public String getDescription() {
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

    public ArrayList<Day> getBusinessDays() {
        return businessDays;
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
                businessDays() + "\n" + businessHours;
    }
}