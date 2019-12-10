package com.example.kaistcampusv2.ui.info;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.kaistcampusv2.ItemListActivity;
import com.example.kaistcampusv2.MainActivity;
import com.example.kaistcampusv2.R;

public class InfoFragment extends Fragment implements View.OnClickListener {
    public static final String INFO_FRAGMENT_MESSAGE = "com.example.kaist_campus.info_fragment.MESSAGE";
    private InfoViewModel infoViewModel;

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

        return root;
    }

    public void onClick(View v)
    {
        switch(v.getId())
        {
            case R.id.academic_button:
            {
                System.out.println("Academic button pressed");
                break;
            }

            case R.id.dormitory_button:
            {
                System.out.println("Dormitory button pressed");
                break;
            }

            case R.id.checklist_button:
            {
                System.out.println("Checklist button pressed");
                break;
            }

            case R.id.contact_button:
            {
                System.out.println("Contact button pressed");
                break;
            }

            case R.id.faq_button:
            {
                System.out.println("FAQ button pressed");
                break;
            }

            case R.id.korea_button:
            {
                System.out.println("Korea button pressed");
                break;
            }

            case R.id.immigration_button:
            {
                System.out.println("Immigration button pressed");
                break;
            }

            case R.id.internet_button:
            {
                System.out.println("Internet button pressed");
                break;
            }
        }
        Intent intent = new Intent(this.getActivity(), ItemListActivity.class);
        intent.putExtra(EXTRA_MESSAGE, stuff);
        startActivity(intent);
    }
}