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

    public OffCampusFacility(int id, String name, String description, boolean isOnCampus, OffCampusFacilityType type, String address, String additionalInfo) {
        super(id, name, description, isOnCampus);
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
