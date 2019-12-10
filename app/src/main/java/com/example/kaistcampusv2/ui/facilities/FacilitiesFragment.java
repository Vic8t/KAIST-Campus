package com.example.kaistcampusv2.ui.facilities;

import android.content.res.AssetManager;
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
import java.io.*;

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

    public void loadData(String file){
        String line;
        BufferedReader csvReader = null;
        AssetManager assetManager = getResources().getAssets();

        try {
            InputStream inputStream = assetManager.open(file);
            csvReader = new BufferedReader(new InputStreamReader(inputStream));
            // csvReader = new BufferedReader(new FileReader(file));
            while((line = csvReader.readLine()) != null){
                String[] data = line.split(";");

                int id = Integer.parseInt(data[0]);
                String name = data[1];
                String description = data[2];
                String type = data[3];
                String location = data[4];
                String[] days = data[5].split(",");
                String hours = data[6];
                boolean onCampus = (data[7].equals("1"));
                String contact = data[8];

                facilitiesArrayList.add(new OnCampusFacility(id, name, description, type, location, days, hours, onCampus, contact));
            }

        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (csvReader != null) {
                try {
                    csvReader.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void createListData()
    {
        loadData("facilities.csv");
        adapter.notifyDataSetChanged();
    }
}