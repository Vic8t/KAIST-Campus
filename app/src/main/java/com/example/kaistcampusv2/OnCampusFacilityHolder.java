package com.example.kaistcampusv2;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class FacilityHolder extends RecyclerView.ViewHolder {
    private TextView name;
    private TextView type;
    private TextView description;
    private TextView building;
    private TextView hours;
    private TextView days;

    public FacilityHolder(View itemView)
    {
        super(itemView);
        name = itemView.findViewById(R.id.txtName);
        type = itemView.findViewById(R.id.txtType);
        description = itemView.findViewById(R.id.txtDesciption);
        building = itemView.findViewById(R.id.txtBuilding);
        hours = itemView.findViewById(R.id.txtHours);
        days = itemView.findViewById(R.id.txtDays);
    }
}
