package com.example.kaistcampusv2.ui.facilities;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kaistcampusv2.OnCampusFacility;
import com.example.kaistcampusv2.OnCampusFacilityAdapter;
import com.example.kaistcampusv2.R;

import java.util.ArrayList;

public class FacilitiesFragment extends Fragment {
    private FacilitiesViewModel facilitiesViewModel;
    private RecyclerView recyclerView;
    private OnCampusFacilityAdapter adapter;
    private ArrayList<OnCampusFacility> facilitiesArrayList;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        facilitiesViewModel =
                ViewModelProviders.of(this).get(FacilitiesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_facilities, container, false);
        recyclerView = (RecyclerView) root.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        facilitiesArrayList = new ArrayList<>();
        adapter = new OnCampusFacilityAdapter(this.getContext(), facilitiesArrayList);
        recyclerView.setAdapter(adapter);
        createListData();

        return root;
    }

    private void createListData()
    {
        String[] businesDays = new String[2];
        businesDays[0] = "MONDAY";
        businesDays[1] = "TUESDAY";

        OnCampusFacility facility = new OnCampusFacility(0, "Something", "Doing stuff", "RESTAURANT", "69"
        , businesDays, "nEvEr", true, "4201337314");
        facilitiesArrayList.add(facility);
        facilitiesArrayList.add(facility);
        facilitiesArrayList.add(facility);
        adapter.notifyDataSetChanged();
    }
}