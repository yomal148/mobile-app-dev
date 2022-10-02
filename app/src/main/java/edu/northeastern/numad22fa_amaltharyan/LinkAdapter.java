package edu.northeastern.numad22fa_amaltharyan;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class LinkAdapter extends RecyclerView.Adapter<LinkViewHolder> {
    public List<Link> linkList;

    public LinkAdapter(List<Link> links){
        this.linkList = linkList;
    }
    @NonNull
    @Override
    public LinkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new LinkViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_link, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull LinkViewHolder holder, int position) {
        Link link = linkList.get(position);
        holder.name.setText(link.getName());
        holder.link.setText(link.getLink());
    }

    @Override
    public int getItemCount() {
        return linkList.size();
    }
}
