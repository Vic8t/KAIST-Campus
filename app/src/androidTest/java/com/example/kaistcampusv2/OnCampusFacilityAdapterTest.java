package com.example.kaistcampusv2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OnCampusFacilityAdapterTest {

    @Test
    public void getFilter() {
        Day c=Day.SATURDAY;
        String d=new String();
        d= c.toString() ;
        String[] bd=new String[]{d};
        CharSequence t= "Shinsegae";        //bd.add("Weekday");
        Facility f = new Facility(1, "Shinsegae Food", "Main cafeteria in Kaimaru", true, bd, "11:30-13:30 and 17:30-19:30", "1");
        assertEquals(f, f);
    }
}