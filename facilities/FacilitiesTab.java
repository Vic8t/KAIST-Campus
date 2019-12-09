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

                int id = Integer.parseInt(data[0]);
                String name = data[1];
                String description = data[2];
                String type = data[3];
                String location = data[4];
                String[] days = data[5].split(",");
                String hours = data[6];
                boolean onCampus = (data[7].equals("1"));
                String contact = data[8];

                if(onCampus){
                    addOnCampusFacility(new OnCampusFacility(id, name, description, type, location, days, hours, onCampus, contact));
                }
                else{
                    addOffCampusFacility(new OffCampusFacility(id, name, description, type, location, days, hours, onCampus, contact));
                }
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
