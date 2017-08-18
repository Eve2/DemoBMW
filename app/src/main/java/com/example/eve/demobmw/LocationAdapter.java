package com.example.eve.demobmw;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import it.sephiroth.android.library.picasso.Picasso;


public class LocationAdapter extends RecyclerView.Adapter<LocationAdapter.ViewHolder> {
    public Context mContext;
    private ArrayList<LocationInfo> locationInfos;

    public LocationAdapter(Context mContext, ArrayList<LocationInfo> locationInfos) {
        this.mContext = mContext;
        this.locationInfos = locationInfos;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_location, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final LocationInfo data = locationInfos.get(position);
        holder.name.setText("Name: " + data.getName());
        holder.address.setText("Address: " + data.getAddress());

    }

    @Override
    public int getItemCount() {
        return locationInfos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView address;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tv_name);
            address = itemView.findViewById(R.id.tv_address);}
    }
}
