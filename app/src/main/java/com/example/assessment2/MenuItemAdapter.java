package com.example.assessment2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MenuItemAdapter extends RecyclerView.Adapter<MenuItemAdapter.MenuItemViewHolder> {
    // Store a member variable for the menu item
    private List<MenuItem> itemList;
    private Context context;

    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    // Add a constructor and pass the array in
    public MenuItemAdapter(List<com.example.assessment2.MenuItem> itemList, Context context) {
        this.itemList = itemList;
        this.context = context;
    }

    // Create new views (invoked by the layout manager)
    public class MenuItemViewHolder extends RecyclerView.ViewHolder {
        public ImageView menuItemImageView;
        public TextView menuItemTextView;

        // Create a constructor that accepts the entire item row and does view lookups to find each subview
        public MenuItemViewHolder(View view) {
            super(view);

            menuItemImageView = view.findViewById(R.id.menuItemImageView);
            menuItemTextView = view.findViewById(R.id.menuItemTextView);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            mListener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

    // Inflate the row layout returning an instance of the class MenuItemViewHolder
    @NonNull
    @Override
    public MenuItemAdapter.MenuItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Create a new view
        View itemView = LayoutInflater.from(context).inflate(R.layout.menu_layout, parent, false);
        return new MenuItemAdapter.MenuItemViewHolder(itemView);
    }

    // Populate data into the item through the holder
    @Override
    public void onBindViewHolder (MenuItemViewHolder holder, int position) {
        // Get elements from the data set at this position, replace contents of view with that element
        holder.menuItemImageView.setImageResource(itemList.get(position).getImage());
        holder.menuItemTextView.setText(itemList.get(position).getName());
    }

    // Return the size of the data set (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return itemList.size();
    }
}