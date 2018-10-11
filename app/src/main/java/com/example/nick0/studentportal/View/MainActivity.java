package com.example.nick0.studentportal.View;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.example.nick0.studentportal.Model.HvaObject;
import com.example.nick0.studentportal.R;
import com.example.nick0.studentportal.Util.PortalAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //Declare the RecyclerView and the fab.
    private RecyclerView hva_recyclerView;
    private FloatingActionButton add_button;
    List<HvaObject> HvAObjects = new ArrayList<>();
    PortalAdapter mAdapter = new PortalAdapter(this, HvAObjects);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Linking the RecyclerView and the button to xml file.
        hva_recyclerView = findViewById(R.id.hva_recyclerview);
        add_button = findViewById(R.id.add_button);

        //Display the RecyclerView in the MainActivity.
        RecyclerView.LayoutManager mLayoutManager = new StaggeredGridLayoutManager(3, LinearLayoutManager.VERTICAL);
        hva_recyclerView.setLayoutManager(mLayoutManager);
        hva_recyclerView.setAdapter(mAdapter);

        //Creating an OnClickListener to the add_button which navigates to the AddPortalActivity.
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddPortalActivity.class);
                startActivityForResult(intent,0);
            }
        });
    }

    //Method which retrieves the Title and URL to the Main Activity from the AddPortalActivity.
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String tmpTitle, tmpurl;
        if (resultCode == RESULT_OK) {
            tmpTitle = data.getStringExtra(AddPortalActivity.EXTRA_TITLE);
            tmpurl = data.getStringExtra(AddPortalActivity.EXTRA_URL);
            HvAObjects.add(new HvaObject(tmpTitle, tmpurl));
            mAdapter.notifyDataSetChanged();
        }
    }
}
