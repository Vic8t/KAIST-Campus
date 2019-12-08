enum OffCampusFacilityType {
    RESTAURANT,
    SUPERMARKET,
    DEPARTMENT_STORE,
    OTHER;
}

public class OffCampusFacility extends Facility {

    private OffCampusFacilityType type;
    private String address;

    public OffCampusFacility(int id, String name, String description, String type, String address, String[] businessDays, String businessHours, boolean isOnCampus, String contactInfo) {
        super(id, name, description, isOnCampus, businessDays, businessHours, contactInfo);
        this.type = OffCampusFacilityType.valueOf(type);
        this.address = address;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + type + ", " + address + "\n";
    }
}
