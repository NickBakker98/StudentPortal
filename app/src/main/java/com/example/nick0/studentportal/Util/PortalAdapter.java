package com.example.nick0.studentportal.Util;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.nick0.studentportal.Model.HvaObject;
import com.example.nick0.studentportal.R;
import com.example.nick0.studentportal.View.WebviewActivity;

import java.util.List;

public class PortalAdapter extends RecyclerView.Adapter<PortalViewholder> {

    private Context context;
    public List<HvaObject> listHvaObject;

    public PortalAdapter(Context context, List<HvaObject> listHvaObject) {
        this.context = context;
        this.listHvaObject = listHvaObject;
    }

    @Override
    public PortalViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_cell, parent, false);
        return new PortalViewholder(view);
    }

    @Override
    public void onBindViewHolder(final PortalViewholder holder, final int position) {
        // Gets a single item in the list from its position
        final HvaObject hvaObject = listHvaObject.get(position);

        //Give the recyclerview an onClickListener which navigates to the WebviewActivity.
        holder.portalNames.setText(hvaObject.getPortalName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, WebviewActivity.class);
                i.putExtra("url", hvaObject.getPortalUrl());
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listHvaObject.size();
    }
}
