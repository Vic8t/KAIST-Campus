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
import androidx.lifecycle.ViewModelProviders;

import com.example.kaistcampusv2.InfoEntry;
import com.example.kaistcampusv2.InfoSection;
import com.example.kaistcampusv2.ItemListActivity;
import com.example.kaistcampusv2.R;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class InfoFragment extends Fragment implements View.OnClickListener {
    public static final String INFO_FRAGMENT_MESSAGE = "com.example.kaist_campus.info_fragment.MESSAGE";
    public static final String SECTION_TYPE = "com.example.kaist_campus.section_type.MESSAGE";
    public static InfoSection checklist_tab;
    public static InfoSection dorm_tab;
    public static InfoSection faq_tab;
    public static InfoSection immigration_tab;
    public static InfoSection internet_tab;
    public static InfoSection academic_tab;
    public static InfoSection contact_tab;
    public static InfoSection korea_tab;
    public static ArrayList<InfoEntry> total_entries = new ArrayList<>();
    public int entry_id = 0;

    private InfoViewModel infoViewModel;

    private String[] checklist_sections = {"Student ID Card", "Orientation Program", "For Degree-Seeking Students"};
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        infoViewModel = ViewModelProviders.of(this).get(InfoViewModel.class);
        View root = inflater.inflate(R.layout.fragment_info, container, false);

        Button academic_button = (Button) root.findViewById(R.id.academic_button);
        Button dormitory_button = (Button) root.findViewById(R.id.dormitory_button);
        Button checklist_button = (Button) root.findViewById(R.id.checklist_button);
        Button contact_button = (Button) root.findViewById(R.id.contact_button);
        Button faq_button = (Button) root.findViewById(R.id.faq_button);
        Button korea_button = (Button) root.findViewById(R.id.korea_button);
        Button immigration_button = (Button) root.findViewById(R.id.immigration_button);
        Button internet_button = (Button) root.findViewById(R.id.internet_button);

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
        String type = "";
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

    public String loadJSONFromAsset(String file_name) {
        String json = null;
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

    public void parse_checklist(JSONObject infoObj)
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

    public void parse_info_section()
    {
        try
        {
            JSONObject infoSectionObj = new JSONObject(loadJSONFromAsset("info_section.json"));
            parse_checklist(infoSectionObj);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}