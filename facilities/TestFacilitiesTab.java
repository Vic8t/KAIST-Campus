import java.util.ArrayList;

public class TestFacilitiesTab {
    public static void main(String[] args) {
        FacilitiesTab facilitiesTab = new FacilitiesTab();
        ArrayList<String> days = new ArrayList<String>();
        days.add("MONDAY");
        facilitiesTab.loadData("facilities.csv");

        // facilitiesTab.addOnCampusFacility(new OnCampusFacility(1, "Backery", "get fresh bread", true, days, OnCampusFacilityType.OTHER, "E4", "info"));

        // facilitiesTab.displayOnCampusFacilities();
    }
}
