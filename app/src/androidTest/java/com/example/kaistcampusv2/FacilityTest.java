package com.example.kaistcampusv2;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class FacilityTest {


    @Test
    public void getName() {
        //Day b=new Day();
        Day c=Day.SATURDAY;
        String d=new String();
        d= c.toString() ;
        String[] bd=new String[]{d};

        //bd.add("Weekday");
        Facility f = new Facility(1, "Shinsegae Food", "Main cafeteria in Kaimaru", true, bd, "11:30-13:30 and 17:30-19:30", "1");

        assertEquals("Shinsegae Food", f.getName());
    }

    @Test
    public void getDescription() {
        Day c=Day.SATURDAY;
        String d=new String();
        d= c.toString() ;
        String[] bd=new String[]{d};

        //bd.add("Weekday");
        Facility f = new Facility(1, "Shinsegae Food", "Main cafeteria in Kaimaru", true, bd, "11:30-13:30 and 17:30-19:30", "1");
        assertEquals("Main cafeteria in Kaimaru", f.getDescription());
    }

    @Test
    public void setDescription() {
        Day c=Day.SATURDAY;
        String d=new String();
        d= c.toString() ;
        String[] bd=new String[]{d};

        //bd.add("Weekday");
        Facility f = new Facility(1, "Shinsegae Food", "Main cafeteria in Kaimaru", true, bd, "11:30-13:30 and 17:30-19:30", "1");
        f.setDescription("Not Main cafeteria in Kaimaru");
        assertEquals("Not Main cafeteria in Kaimaru", f.getDescription());
    }

    @Test
    public void isOnCampus() {
        Day c=Day.SATURDAY;
        String d=new String();
        d= c.toString() ;
        String[] bd=new String[]{d};

        //bd.add("Weekday");
        Facility f = new Facility(1, "Shinsegae Food", "Main cafeteria in Kaimaru", true, bd, "11:30-13:30 and 17:30-19:30", "1");
        assertEquals(true, f.isOnCampus());
    }

    @Test
    public void getBusinessDays() {
        Day c=Day.SATURDAY;
        String d=new String();
        d= c.toString() ;
        Day c1=Day.SUNDAY;
        String d1=new String();
        d1= c1.toString() ;
        Day c2=Day.WEEKDAYS;
        String d2=new String();
        d2= c2.toString() ;
        String[] bd=new String[]{d2,d,d1};

        //bd.add("Weekday");
        Facility f = new Facility(1, "Shinsegae Food", "Main cafeteria in Kaimaru", true, bd, "11:30-13:30 and 17:30-19:30", "1");
        assertEquals("Everyday", f.getBusinessDays());
    }

    @Test
    public void setBusinessDays() {
        Day c=Day.SATURDAY;
        String d=new String();
        d= c.toString() ;

        Day c3=Day.SUNDAY;
        String d3=new String();
        d3= c3.toString() ;


        Day c1=Day.WEEKDAYS;
        String d1=new String();
        d1= c1.toString() ;
        //String[] bd1=new String[]{d1};
        String[] bd=new String[]{d1,d};
        ArrayList<Day> bd2 = new ArrayList<Day>(3);

        bd2.add(c1);
        bd2.add(c);
        bd2.add(c3);
        Facility f = new Facility(1, "Shinsegae Food", "Main cafeteria in Kaimaru", true, bd, "11:30-13:30 and 17:30-19:30", "1");
        f.setBusinessDays(bd2);
        assertEquals("Everyday", f.getBusinessDays());
    }

    @Test
    public void getBusinessHours() {
        Day c=Day.SATURDAY;
        String d=new String();
        d= c.toString() ;
        String[] bd=new String[]{d};

        //bd.add("Weekday");
        Facility f = new Facility(1, "Shinsegae Food", "Main cafeteria in Kaimaru", true, bd, "11:30-13:30 and 17:30-19:30", "1");
        assertEquals("11:30-13:30 and 17:30-19:30", f.getBusinessHours());
    }

    @Test
    public void setBusinessHours() {
        Day c=Day.SATURDAY;
        String d=new String();
        d= c.toString() ;
        String[] bd=new String[]{d};

        //bd.add("Weekday");
        Facility f = new Facility(1, "Shinsegae Food", "Main cafeteria in Kaimaru", true, bd, "11:30-13:30 and 17:30-19:30", "1");
        f.setBusinessHours("8:00-20:00");
        assertEquals("8:00-20:00", f.getBusinessHours());
    }

    @Test
    public void getContactInfo() {
        Day c=Day.SATURDAY;
        String d=new String();
        d= c.toString() ;
        String[] bd=new String[]{d};

        //bd.add("Weekday");
        Facility f = new Facility(1, "Shinsegae Food", "Main cafeteria in Kaimaru", true, bd, "11:30-13:30 and 17:30-19:30", "1");
        assertEquals("1", f.getContactInfo());
    }

    @Test
    public void setContactInfo() {
        Day c=Day.SATURDAY;
        String d=new String();
        d= c.toString() ;
        String[] bd=new String[]{d};

        //bd.add("Weekday");
        Facility f = new Facility(1, "Shinsegae Food", "Main cafeteria in Kaimaru", true, bd, "11:30-13:30 and 17:30-19:30", "1");
        f.setContactInfo("22");
        assertEquals("22", f.getContactInfo());
    }

    @Test
    public void getId() {
        Day c=Day.SATURDAY;
        String d=new String();
        d= c.toString() ;
        String[] bd=new String[]{d};

        //bd.add("Weekday");
        Facility f = new Facility(1, "Shinsegae Food", "Main cafeteria in Kaimaru", true, bd, "11:30-13:30 and 17:30-19:30", "1");
        assertEquals(1, f.getId());
    }

    @Test
    public void setId() {
        Day c=Day.SATURDAY;
        String d=new String();
        d= c.toString() ;
        String[] bd=new String[]{d};

        //bd.add("Weekday");
        Facility f = new Facility(1, "Shinsegae Food", "Main cafeteria in Kaimaru", true, bd, "11:30-13:30 and 17:30-19:30", "1");
        f.setId(23);
        assertEquals(23, f.getId());
    }


    @Test
    public void setName() {
        Day c=Day.SATURDAY;
        String d=new String();
        d= c.toString() ;
        String[] bd=new String[]{d};

        //bd.add("Weekday");
        Facility f = new Facility(1, "Shinsegae Food", "Main cafeteria in Kaimaru", true, bd, "11:30-13:30 and 17:30-19:30", "1");
        f.setName("Ttukbaegi (MJ Food)");
        assertEquals("Ttukbaegi (MJ Food)", f.getName());
    }












}