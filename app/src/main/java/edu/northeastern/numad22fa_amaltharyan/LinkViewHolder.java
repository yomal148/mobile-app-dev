package edu.northeastern.numad22fa_amaltharyan;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class LinkViewHolder extends RecyclerView.ViewHolder{

    public TextView name;
    public TextView link;

    public LinkViewHolder(@NonNull View itemView) {
        super(itemView);
        this.name = itemView.findViewById(R.id.name);
        this.link = itemView.findViewById(R.id.link);
    }
}
