import java.util.ArrayList;
import java.io.*;

public class FacilitiesTab {

    private ArrayList<OnCampusFacility> onCampusFacilities;
    private ArrayList<OffCampusFacility> offCampusFacilities;
    private boolean isTabOpen;

    public FacilitiesTab() {
        this.onCampusFacilities = new ArrayList<OnCampusFacility>();
        this.offCampusFacilities = new ArrayList<OffCampusFacility>();
        this.isTabOpen = false;
    }

    public void loadData(String file){
        String line = "";
        BufferedReader csvReader = null;

        try {
            csvReader = new BufferedReader(new FileReader(file));
            while((line = csvReader.readLine()) != null){
                String[] data = line.split(";");
                for(int i = 0; i < data.length; i++)
                    System.out.println(data[i]);
            }

        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (csvReader != null) {
                try {
                    csvReader.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
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
