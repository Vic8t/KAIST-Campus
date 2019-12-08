import java.util.ArrayList;

enum Day {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;
}

public class Facility {

    private int id;
    private String name;
    private String description;
    // private Image image;
    // private Icon icon;
    private boolean isOnCampus;
    private ArrayList<Day> businessDays;
    private String businessHours;
    private String contactInfo;

    public Facility(int id, String name, String description, boolean isOnCampus, String[] businessDays, String businessHours, String contactInfo) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.isOnCampus = isOnCampus;
        this.businessDays = new ArrayList<Day>();
        for(int i = 0; i < businessDays.length; i++){
            this.businessDays.add(Day.valueOf(businessDays[i]));
        }
        this.businessHours = businessHours;
        this.contactInfo = contactInfo;
    }

    public String businessDays(){
        if(businessDays.size() == 7){
            return "EVERYDAY";
        }
        else if(businessDays.size() == 6 && !businessDays.contains(Day.SUNDAY)){
            return "MONDAY~FRIDAY, SATURDAY";
        }
        else if(businessDays.size() == 5 && !businessDays.contains(Day.SATURDAY) && !businessDays.contains(Day.SUNDAY)){
            return "MONDAY~FRIDAY";
        }
        else{
            String days = "";
            for(int i = 0; i < businessDays.size(); i++){
                days += businessDays.get(i);
                if(i != businessDays.size() - 1){
                    days += ", ";
                }
            }
            return days;
        }
    }

    @Override
    public String toString() {
        return id + ": " + name + "\n" + description + "\n" +
        businessDays() + "\n" + businessHours;
    }
}
