package com.example.kaistcampusv2;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class OnCampusFacilityAdapter extends RecyclerView.Adapter<OnCampusFacilityAdapter.OnCampusFacilityHolder> implements Filterable {
    private Context context;
    private List<OnCampusFacility> facilities;
    private List<OnCampusFacility> facilitiesFull;

    public OnCampusFacilityAdapter(Context context, List<OnCampusFacility> facilities)
    {
        this.context = context;
        this.facilities = facilities;
        facilitiesFull = new ArrayList<>(facilities);
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

    @Override
    public Filter getFilter() {
        return facilitiesFilter;
    }

    private Filter facilitiesFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<OnCampusFacility> facilitiesMatched = new ArrayList<>();

            if(constraint == null || constraint.length() == 0){
                facilitiesMatched.addAll(facilitiesFull);
            }

            else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for(OnCampusFacility facility : facilitiesFull){
                    if(facility.getName().toLowerCase().contains(filterPattern)
                    || facility.getBuilding().toLowerCase().contains(filterPattern)
                    || facility.getType().toString().toLowerCase().contains(filterPattern))
                        facilitiesMatched.add(facility);
                }
            }

            FilterResults results = new FilterResults();
            results.values = facilitiesMatched;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            facilities.clear();
            facilities.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };

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
            description = itemView.findViewById(R.id.txtDescription);
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
            days.setText(facility.getBusinessDays());
        }
    }
}
