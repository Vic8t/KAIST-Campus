package com.example.kaistcampusv2;

import java.util.ArrayList;

public class InfoSection {
    public String title;
    public ArrayList<InfoEntry> info_entries;

    public InfoSection(String title, ArrayList<InfoEntry> info_entries)
    {
        this.title = title;
        this.info_entries = info_entries;
    }
}
