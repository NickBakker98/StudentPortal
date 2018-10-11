package com.example.nick0.studentportal.Util;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.nick0.studentportal.R;

public class PortalViewholder extends RecyclerView.ViewHolder {

    public TextView portalNames;
    public View view;

    public PortalViewholder(View itemView) {
        super(itemView);
        portalNames = itemView.findViewById(R.id.portalTextView);
        view = itemView;
    }


}
