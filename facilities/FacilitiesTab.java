import java.util.ArrayList;

public class FacilitiesTab {

    private ArrayList<OnCampusFacility> onCampusFacilities;
    private ArrayList<OffCampusFacility> offCampusFacilities;
    private boolean isTabOpen;

    public FacilitiesTab() {
        this.onCampusFacilities = new ArrayList<OnCampusFacility>();
        this.offCampusFacilities = new ArrayList<OffCampusFacility>();
        this.isTabOpen = false;
    }

    public void addOnCampusFacility(OnCampusFacility facility){
        onCampusFacilities.add(facility);
    }

    public void addOffCampusFacility(OffCampusFacility facility){
        offCampusFacilities.add(facility);
    }

    public void displayOnCampusFacilities(){
        for(OnCampusFacility facility : onCampusFacilities){
            System.out.println(facility);
        }
    }

    public void displayOffCampusFacilities(){
        for(OffCampusFacility facility : offCampusFacilities){
            System.out.println(facility);
        }
    }
}
