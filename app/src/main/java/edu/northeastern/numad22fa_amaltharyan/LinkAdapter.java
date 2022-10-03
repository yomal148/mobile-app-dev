package edu.northeastern.numad22fa_amaltharyan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class LinkAdapter extends RecyclerView.Adapter<LinkViewHolder> {
    private ArrayList<Link> linkList;
    private Context context;
    private ItemClickListener ClickListener;
    private LayoutInflater Inflater;

    public LinkAdapter(Context context, List<Link> links){
        this.linkList = linkList;
        this.Inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public LinkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = Inflater.inflate(R.layout.item_link, parent, false);
        return new LinkViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LinkViewHolder holder, int position) {
        holder.link.setText(linkList.get(position).getName());
        holder.name.setText(linkList.get(position).getLink());

    }

    @Override
    public int getItemCount() {
        return linkList.size();
    }
}
