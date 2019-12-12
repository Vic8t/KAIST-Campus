package com.example.kaistcampusv2.ui.info;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import org.json.JSONException;
import org.json.JSONObject;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.kaistcampusv2.InfoEntry;
import com.example.kaistcampusv2.InfoSection;
import com.example.kaistcampusv2.ItemListActivity;
import com.example.kaistcampusv2.R;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class InfoFragment extends Fragment implements View.OnClickListener {
    public static final String SECTION_TYPE = "com.example.kaist_campus.section_type.MESSAGE";
    public static InfoSection checklist_tab;
    public static InfoSection dorm_tab;
    public static InfoSection faq_tab;
    public static InfoSection immigration_tab;
    public static InfoSection internet_tab;
    public static InfoSection academic_tab;
    public static InfoSection contact_tab;
    public static InfoSection korea_tab;
    public static String type;
    public static ArrayList<InfoEntry> total_entries = new ArrayList<>();
    private int entry_id = 0;

    private String[] checklist_sections = {"Student ID Card", "Orientation Program", "For Degree-Seeking Students",
    "For Exchange Students", "For Interns/Visiting Students"};
    private String[] contact_sections = {"International Scholar & Student Services", "International Relations Team", "Academic Registrar’s Team", "Student Life Team", "Scholarship & Welfare", "International Admissions", "Information & Communications Team", "KAIST Counseling Center", "Global Leadership Center", "Emergency Contacts"};
    private String[] korea_sections = {"About Korea", "General Information", "Weather and Climate", "Food", "Language", "National Holidays", "Useful Websites"};
    private String[] dorm_sections = {"Dormitory Overview", "Dormitory Application", "Living in Dormitories", "Moving Out"};
    private String[] internet_sections = {"KAIST Official Website", "KAIST Portal", "KAIST Mail", "KLMS", "Unified Reservation Service", "Other Useful Sites"};
    private String[] academic_sections = {"Course Enrollment", "Tuition Fee", "Credit System", "Grading System", "Academic Certificates", "KAIST Scholarship for International Students", "Academic Support", "Language Support"};
    private String[] immigration_sections = {"Alien Registration", "Extension of Stay", "Reissuance of Alien Registration Card", "Part-time Work Permission", "Reporting Changes of Alien Registration", "Leave of Absence"};
    private String[] faq_sections = {"Living in Korea", "School Life", "Health", "Academic", "Immigration", "Religious Life", "Dormitory"};


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_info, container, false);

        Button academic_button = root.findViewById(R.id.academic_button);
        Button dormitory_button = root.findViewById(R.id.dormitory_button);
        Button checklist_button = root.findViewById(R.id.checklist_button);
        Button contact_button = root.findViewById(R.id.contact_button);
        Button faq_button = root.findViewById(R.id.faq_button);
        Button korea_button = root.findViewById(R.id.korea_button);
        Button immigration_button = root.findViewById(R.id.immigration_button);
        Button internet_button = root.findViewById(R.id.internet_button);

        academic_button.setOnClickListener(this);
        dormitory_button.setOnClickListener(this);
        checklist_button.setOnClickListener(this);
        contact_button.setOnClickListener(this);
        faq_button.setOnClickListener(this);
        korea_button.setOnClickListener(this);
        immigration_button.setOnClickListener(this);
        internet_button.setOnClickListener(this);

        parse_info_section();

        return root;
    }

    public void onClick(View v)
    {
        switch(v.getId())
        {
            case R.id.academic_button:
            {
                type = "ACADEMIC";
                break;
            }

            case R.id.dormitory_button:
            {
                type = "DORMITORY";
                break;
            }

            case R.id.checklist_button:
            {
                type = "CHECKLIST";
                break;
            }

            case R.id.contact_button:
            {
                type = "CONTACT";
                break;
            }

            case R.id.faq_button:
            {
                type = "FAQ";
                break;
            }

            case R.id.korea_button:
            {
                type = "KOREA";
                break;
            }

            case R.id.immigration_button:
            {
                type = "IMMIGRATION";
                break;
            }

            case R.id.internet_button:
            {
                type = "INTERNET";
                break;
            }
        }

        Intent intent = new Intent(this.getActivity(), ItemListActivity.class);
        intent.putExtra(SECTION_TYPE, type);
        startActivity(intent);
    }

    private String loadJSONFromAsset(String file_name) {
        String json ;
        try {
            InputStream is = getActivity().getAssets().open(file_name);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    private void parse_checklist(JSONObject infoObj)
    {
        try {
            JSONObject checklist = infoObj.getJSONObject("New Student's Checklist");
            ArrayList<InfoEntry> info_entries = new ArrayList<>();

            for (String str: checklist_sections) {
                String section_desc = checklist.getString(str);
                InfoEntry section_entry = new InfoEntry(entry_id, str, section_desc);
                info_entries.add(section_entry);
                total_entries.add(section_entry);
                entry_id++;
            }

            checklist_tab = new InfoSection("New Student's Checklist", info_entries);
        } catch (JSONException e)
        {
            e.printStackTrace();
        }
    }

    private void parse_contact(JSONObject infoObj)
    {
        try {
            JSONObject contact = infoObj.getJSONObject("Office Contact Info");
            ArrayList<InfoEntry> info_entries = new ArrayList<>();

            for (String str: contact_sections) {
                String section_desc = contact.getString(str);
                InfoEntry section_entry = new InfoEntry(entry_id, str, section_desc);
                info_entries.add(section_entry);
                total_entries.add(section_entry);
                entry_id++;
            }

            contact_tab = new InfoSection("Office Contact Info", info_entries);
        } catch (JSONException e)
        {
            e.printStackTrace();
        }
    }

    private void parse_korea(JSONObject infoObj)
    {
        try {
            JSONObject contact = infoObj.getJSONObject("Korea at a Glance");
            ArrayList<InfoEntry> info_entries = new ArrayList<>();

            for (String str: korea_sections) {
                String section_desc = contact.getString(str);
                InfoEntry section_entry = new InfoEntry(entry_id, str, section_desc);
                info_entries.add(section_entry);
                total_entries.add(section_entry);
                entry_id++;
            }

            korea_tab = new InfoSection("Korea at a Glance", info_entries);
        } catch (JSONException e)
        {
            e.printStackTrace();
        }
    }

    private void parse_dorm(JSONObject infoObj)
    {
        try {
            JSONObject accommodation = infoObj.getJSONObject("Accommodation");
            ArrayList<InfoEntry> info_entries = new ArrayList<>();

            for (String str: dorm_sections) {
                String section_desc = accommodation.getString(str);
                InfoEntry section_entry = new InfoEntry(entry_id, str, section_desc);
                info_entries.add(section_entry);
                total_entries.add(section_entry);
                entry_id++;
            }

            dorm_tab = new InfoSection("Accomodation", info_entries);
        } catch (JSONException e)
        {
            e.printStackTrace();
        }
    }

    private void parse_internet(JSONObject infoObj)
    {
        try {
            JSONObject intranet = infoObj.getJSONObject("KAIST Intranet");
            ArrayList<InfoEntry> info_entries = new ArrayList<>();

            for (String str: internet_sections) {
                String section_desc = intranet.getString(str);
                InfoEntry section_entry = new InfoEntry(entry_id, str, section_desc);
                info_entries.add(section_entry);
                total_entries.add(section_entry);
                entry_id++;
            }

            internet_tab = new InfoSection("KAIST Intranet", info_entries);
        } catch (JSONException e)
        {
            e.printStackTrace();
        }
    }

    private void parse_academic(JSONObject infoObj)
    {
        try {
            JSONObject academic = infoObj.getJSONObject("Academic");
            ArrayList<InfoEntry> info_entries = new ArrayList<>();

            for (String str: academic_sections) {
                String section_desc = academic.getString(str);
                InfoEntry section_entry = new InfoEntry(entry_id, str, section_desc);
                info_entries.add(section_entry);
                total_entries.add(section_entry);
                entry_id++;
            }

            academic_tab = new InfoSection("Academic", info_entries);
        } catch (JSONException e)
        {
            e.printStackTrace();
        }
    }

    private void parse_immigration(JSONObject infoObj)
    {
        try {
            JSONObject immigration = infoObj.getJSONObject("Immigration");
            ArrayList<InfoEntry> info_entries = new ArrayList<>();

            for (String str: immigration_sections) {
                String section_desc = immigration.getString(str);
                InfoEntry section_entry = new InfoEntry(entry_id, str, section_desc);
                info_entries.add(section_entry);
                total_entries.add(section_entry);
                entry_id++;
            }

            immigration_tab = new InfoSection("Immigration", info_entries);
        } catch (JSONException e)
        {
            e.printStackTrace();
        }
    }

    private void parse_faq(JSONObject infoObj)
    {
        try {
            JSONObject faq = infoObj.getJSONObject("FAQ");
            ArrayList<InfoEntry> info_entries = new ArrayList<>();

            for (String str: faq_sections) {
                String section_desc = faq.getString(str);
                InfoEntry section_entry = new InfoEntry(entry_id, str, section_desc);
                info_entries.add(section_entry);
                total_entries.add(section_entry);
                entry_id++;
            }

            faq_tab = new InfoSection("FAQ", info_entries);
        } catch (JSONException e)
        {
            e.printStackTrace();
        }
    }

    private void parse_info_section()
    {
        try
        {
            JSONObject infoSectionObj = new JSONObject(loadJSONFromAsset("info_section.json"));
            parse_checklist(infoSectionObj);
            parse_contact(infoSectionObj);
            parse_korea(infoSectionObj);
            parse_dorm(infoSectionObj);
            parse_internet(infoSectionObj);
            parse_academic(infoSectionObj);
            parse_immigration(infoSectionObj);
            parse_faq(infoSectionObj);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}