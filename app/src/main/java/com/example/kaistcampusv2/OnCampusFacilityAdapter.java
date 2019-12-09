package com.example.kaistcampusv2;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class OnCampusFacilityAdapter extends RecyclerView.Adapter<OnCampusFacilityAdapter.OnCampusFacilityHolder> {
    private Context context;
    private ArrayList<OnCampusFacility> facilities;

    public OnCampusFacilityAdapter(Context context, ArrayList<OnCampusFacility> facilities)
    {
        this.context = context;
        this.facilities = facilities;
    }

    @NonNull
    @Override
    public OnCampusFacilityHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_row, parent, false);
        return new OnCampusFacilityHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OnCampusFacilityHolder holder, int position) {
        OnCampusFacility facility = facilities.get(position);
        holder.setDetails(facility);
    }

    @Override
    public int getItemCount() {
        return facilities.size();
    }

    class OnCampusFacilityHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView type;
        private TextView description;
        private TextView building;
        private TextView hours;
        private TextView days;

        public OnCampusFacilityHolder(View itemView)
        {
            super(itemView);
            name = itemView.findViewById(R.id.txtName);
            type = itemView.findViewById(R.id.txtType);
            description = itemView.findViewById(R.id.txtDesciption);
            building = itemView.findViewById(R.id.txtBuilding);
            hours = itemView.findViewById(R.id.txtHours);
            days = itemView.findViewById(R.id.txtDays);
        }

        void setDetails(OnCampusFacility facility)
        {
            name.setText(facility.getName());
            type.setText(facility.getType().toString());
            description.setText(facility.getDescription());
            building.setText(facility.getBuilding());
            hours.setText(facility.getBusinessHours());
            days.setText(facility.getBusinessDays().toString());
        }
    }
}