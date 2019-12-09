enum OnCampusFacilityType {
    RESTAURANT,
    CAFETERIA,
    CAFE,
    DORMITORY,
    CONVENIENCE_STORE,
    SPORTS,
    MEDICAL,
    LANDMARK,
    OTHER;
}

public class OnCampusFacility extends Facility {

    private OnCampusFacilityType type;
    private String building;

    public OnCampusFacility(int id, String name, String description, String type, String building, String[] businessDays, String businessHours, boolean isOnCampus, String contactInfo) {
        super(id, name, description, isOnCampus, businessDays, businessHours, contactInfo);
        this.type = OnCampusFacilityType.valueOf(type);
        this.building = building;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +  type + " in " + building + "\n";
    }
}
