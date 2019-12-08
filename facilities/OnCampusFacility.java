import java.util.ArrayList;

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
    private String additionalInfo;

    public OnCampusFacility(int id, String name, String description, boolean isOnCampus, ArrayList<String> businessDays, OnCampusFacilityType type, String building, String additionalInfo) {
        super(id, name, description, isOnCampus, businessDays);
        this.type = type;
        this.building = building;
        this.additionalInfo = additionalInfo;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +  type + ", " + building + ", " + additionalInfo;
    }
}
