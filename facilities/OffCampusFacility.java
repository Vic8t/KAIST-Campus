import java.util.ArrayList;

enum OffCampusFacilityType {
    RESTAURANT,
    SUPERMARKET,
    DEPARTMENT_STORE,
    OTHER;
}

public class OffCampusFacility extends Facility {

    private OffCampusFacilityType type;
    private String address;
    private String additionalInfo;

    public OffCampusFacility(int id, String name, String description, boolean isOnCampus, ArrayList<String> businessDays, OffCampusFacilityType type, String address, String additionalInfo) {
        super(id, name, description, isOnCampus, businessDays);
        this.type = type;
        this.address = address;
        this.additionalInfo = additionalInfo;
    }

    @Override
    public String toString() {
        System.out.println(this);
        return type + ", " + address + ", " + additionalInfo;
    }
}
