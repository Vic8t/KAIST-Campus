package com.example.kaistcampusv2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OnCampusFacilityTest {

    @Test
    public void getBuilding() {
        Day c=Day.SATURDAY;
        String d=new String();
        d= c.toString() ;
        String[] bd=new String[]{d};
        //bd.add("Weekday");
        OnCampusFacility f = new OnCampusFacility(1, "Shinsegae Food", "Main cafeteria in Kaimaru", "CAFETERIA", "N11", bd, "11:30-13:30 and 17:30-19:30;",true,"1");
        assertEquals("N11", f.getBuilding());
    }

    @Test
    public void setBuilding() {
        Day c=Day.SATURDAY;
        String d=new String();
        d= c.toString() ;
        String[] bd=new String[]{d};
        //bd.add("Weekday");
        OnCampusFacility f = new OnCampusFacility(1, "Shinsegae Food", "Main cafeteria in Kaimaru", "CAFETERIA", "N11", bd, "11:30-13:30 and 17:30-19:30;",true,"1");
        f.setBuilding("E11");
        assertEquals("E11", f.getBuilding());
    }

    @Test
    public void getType() {
        Day c=Day.SATURDAY;
        String d=new String();
        d= c.toString() ;
        String[] bd=new String[]{d};
        //bd.add("Weekday");
        OnCampusFacility f = new OnCampusFacility(1, "Shinsegae Food", "Main cafeteria in Kaimaru", "CAFETERIA", "N11", bd, "11:30-13:30 and 17:30-19:30;",true,"1");
        assertEquals(OnCampusFacilityType.CAFETERIA, f.getType());
    }

    @Test
    public void setType() {
        Day c=Day.SATURDAY;
        String d=new String();
        d= c.toString() ;
        String[] bd=new String[]{d};
        //bd.add("Weekday");
        OnCampusFacilityType qwe=OnCampusFacilityType.LIBRARY;
        OnCampusFacility f = new OnCampusFacility(1, "Shinsegae Food", "Main cafeteria in Kaimaru", "CAFETERIA", "N11", bd, "11:30-13:30 and 17:30-19:30;",true,"1");
        f.setType(qwe);
        assertEquals(qwe, f.getType());
    }

}