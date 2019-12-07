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
    // private ArrayList<Day> businessDays;

    public Facility(int id, String name, String description, boolean isOnCampus) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.isOnCampus = isOnCampus;
        // this.businessDays = new ArrayList<Day>();
        // for(String day : days){
        //     businessDays.add(Day.valueOf(day));
        // }
    }

    // public String displayBusinessDays(){
    //     if(businessDays.size() == 7){
    //         return "EVERYDAY";
    //     }
    //     else if(businessDays.size() == 5 && !businessDays.contains(Day.SATURDAY) && !businessDays.contains(Day.SUNDAY)){
    //         return "MONDAY~FRIDAY";
    //     }
    //     else{
    //         int i;
    //         String days = "";
    //         for(i = 0; i < businessDays.size(); i++){
    //             days += businessDays.get(i);
    //             if(i == businessDays.size() - 1){
    //                 days += ", ";
    //             }
    //         }
    //         return days;
    //     }
    // }

    @Override
    public String toString() {
        return id + ": " + name + " (" + description + ")"; // + "\n" +
        // "Business days: " + displayBusinessDays();
    }
}
