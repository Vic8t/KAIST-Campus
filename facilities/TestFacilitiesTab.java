public class TestFacilitiesTab {
    public static void main(String[] args) {

        FacilitiesTab facilitiesTab = new FacilitiesTab();
        facilitiesTab.loadData("facilities.csv");

        facilitiesTab.displayOnCampusFacilities();
    }
}
