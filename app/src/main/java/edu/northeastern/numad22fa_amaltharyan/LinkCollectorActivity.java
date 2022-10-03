package edu.northeastern.numad22fa_amaltharyan;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


public class LinkCollectorActivity extends AppCompatActivity {
    RecyclerView linkRecyclerView;
    ArrayList<Link> linkList;
    LinkAdapter adapter;
    FloatingActionButton floatingActionButton;
    EditText linkName;
    EditText link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_link_collector);

        // Instantiate the link list
        linkList = new ArrayList<>();
        linkList.add(new Link("g", "google.com"));
        linkRecyclerView = findViewById(R.id.link_recycler_view);
        //linkRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new LinkAdapter(this, linkList);
        linkRecyclerView.setAdapter(adapter);

        floatingActionButton = findViewById(R.id.floatingActionButton);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("User Input")
                .setMessage("Please fill in the name and link url");
        LinearLayout layout= new LinearLayout(this); // creating layout for dialog box
        layout.setOrientation(LinearLayout.VERTICAL); // set vertical orientation for layout
        linkName = new EditText(this);
        link = new EditText(this);
        linkName.setHint("Enter Name");
        link.setHint("Enter Link");
        layout.addView(linkName);
        layout.addView(link);
        builder.setView(layout);
        builder.setPositiveButton("Submit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                String name = linkName.getText().toString();
                String url = link.getText().toString();

                linkList.add(new Link(name, url));

                adapter.notifyItemInserted(linkList.size()-1);

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


}