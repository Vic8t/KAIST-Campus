package com.example.kaistcampusv2;

import android.app.Activity;
import android.os.Bundle;

import com.example.kaistcampusv2.ui.info.InfoFragment;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ItemDetailFragment extends Fragment {
    public static final String ARG_ITEM_ID = "item_id";
    private InfoEntry entry;
    public ItemDetailFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            System.out.println(getArguments().getString(ARG_ITEM_ID));
            entry = InfoFragment.total_entries.get(Integer.parseInt(getArguments().getString(ARG_ITEM_ID)));

            if (appBarLayout != null) {
                appBarLayout.setTitle(entry.title);
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item_detail, container, false);

        if (entry != null) {
            ((TextView) rootView.findViewById(R.id.item_detail)).setText(entry.description);
        }

        return rootView;
    }
}
