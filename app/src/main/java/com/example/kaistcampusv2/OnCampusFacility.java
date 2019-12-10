package com.example.kaistcampusv2;

enum OnCampusFacilityType {
    RESTAURANT,
    CAFETERIA,
    CAFE,
    LIBRARY,
    CONVENIENCE_STORE,
    SHOP,
    SPORTS,
    CULTURAL,
    MEDICAL,
    LANDMARK,
    OTHER
}

public class OnCampusFacility extends Facility {
    private OnCampusFacilityType type;
    private String building;

    public OnCampusFacility(int id, String name, String description, String type, String building, String[] businessDays, String businessHours, boolean isOnCampus, String contactInfo) {
        super(id, name, description, isOnCampus, businessDays, businessHours, contactInfo);
        this.type = OnCampusFacilityType.valueOf(type);
        this.building = building;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public OnCampusFacilityType getType() {
        return type;
    }

    public void setType(OnCampusFacilityType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +  type + " in " + building + "\n";
    }
}
