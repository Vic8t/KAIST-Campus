package com.example.kaistcampusv2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import com.example.kaistcampusv2.ui.info.InfoFragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;

public class ItemListActivity extends AppCompatActivity {
    public static InfoSection clicked_section;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);
        Intent intent = getIntent();
        String clicked_tab = intent.getStringExtra(InfoFragment.SECTION_TYPE);

        if (clicked_tab != null)
        {
            switch (clicked_tab)
            {
                case "ACADEMIC":
                    clicked_section = InfoFragment.academic_tab;
                    break;
                case "DORMITORY":
                    clicked_section = InfoFragment.dorm_tab;
                    break;
                case "IMMIGRATION":
                    clicked_section = InfoFragment.immigration_tab;
                    break;
                case "KOREA":
                    clicked_section = InfoFragment.korea_tab;
                    break;
                case "FAQ":
                    clicked_section = InfoFragment.faq_tab;
                    break;
                case "CHECKLIST":
                    clicked_section = InfoFragment.checklist_tab;
                    break;
                case "CONTACT":
                    clicked_section = InfoFragment.contact_tab;
                    break;
                case "INTERNET":
                    clicked_section = InfoFragment.internet_tab;
                    break;
            }
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(clicked_section.title);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        View recyclerView = findViewById(R.id.item_list);
        assert recyclerView != null;

        setupRecyclerView((RecyclerView) recyclerView);
    }

    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(new SimpleItemRecyclerViewAdapter(this, clicked_section.info_entries));
    }

    public static class SimpleItemRecyclerViewAdapter
            extends RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder> {

        private final ItemListActivity mParentActivity;
        public final ArrayList<InfoEntry> mValues;

        private final View.OnClickListener mOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InfoEntry info_entry = (InfoEntry) view.getTag();

                Context context = view.getContext();
                Intent intent = new Intent(context, ItemDetailActivity.class);
                intent.putExtra(ItemDetailFragment.ARG_ITEM_ID, String.valueOf(info_entry.id));
                context.startActivity(intent);
            }
        };

        SimpleItemRecyclerViewAdapter(ItemListActivity parent,
                                      ArrayList<InfoEntry> entries) {
            mValues = entries;
            mParentActivity = parent;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_list_content, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            holder.mContentView.setText(mValues.get(position).title);
            holder.itemView.setTag(mValues.get(position));
            holder.itemView.setOnClickListener(mOnClickListener);
        }

        @Override
        public int getItemCount() {
            return mValues.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            final TextView mContentView;

            ViewHolder(View view) {
                super(view);
                mContentView = (TextView) view.findViewById(R.id.content);
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            NavUtils.navigateUpTo(this, new Intent(this, InfoFragment.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
