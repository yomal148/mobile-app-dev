package edu.northeastern.numad22fa_amaltharyan;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;


public class LinkCollectorActivity extends AppCompatActivity {
    RecyclerView linkRecyclerView;
    List<Link> linkList;
    LinkAdapter adapter;
    FloatingActionButton floatingActionButton;
    final Context context = this;
    EditText linkName;
    EditText link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_link_collector);

        // Instantiate the link list
        linkList = new ArrayList<>();


        linkRecyclerView = findViewById(R.id.link_recycler_view);

        //Add Linear layout orientation to recycler view
        linkRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        linkRecyclerView.setHasFixedSize(true);
        linkRecyclerView.setAdapter(adapter);

        floatingActionButton = findViewById(R.id.floatingActionButton);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("User Input")
                .setMessage("Please fill in the link url and name");
        LinearLayout layout= new LinearLayout(this); // creating layout for dialog box
        layout.setOrientation(LinearLayout.VERTICAL); // set vertical orientation for layout
        linkName = new EditText(this);
        link = new EditText(this);
        layout.addView(linkName);
        layout.addView(link);
        builder.setView(layout);
        builder.setPositiveButton("Submit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                linkData();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        final AlertDialog ad = builder.create();
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ad.show();
            }
        });

    }

    public void linkData() {
        String name = linkName.getText().toString();
        String url = link.getText().toString();

        Toast.makeText(getApplicationContext(), name, Toast.LENGTH_LONG).show();
        /**
        Link link1 = new Link(name, url);
        linkList.add(link1);

        adapter.notifyDataSetChanged();
         */
    }


}