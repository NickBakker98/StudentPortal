package com.example.nick0.studentportal.View;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.nick0.studentportal.R;

public class AddPortalActivity extends AppCompatActivity {


    //Declare the TextViews and the button
    private Button addPortalButton;
    private TextView urlTextView;
    private EditText urlinputTextView;
    private TextView titleTextView;
    private EditText titleinputTextView;
    private String mTitle;
    private String mURL;

    public static final String EXTRA_TITLE = "a title";
    public static final String EXTRA_URL = "a URL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addportal);

        //Linking the textviews and the button to the textviews in the xml file.
        addPortalButton = findViewById(R.id.add_portal_button);
        urlTextView = findViewById(R.id.urlTextView);
        urlinputTextView = findViewById(R.id.urlInputText);
        titleTextView = findViewById(R.id.titleTextView);
        titleinputTextView = findViewById(R.id.titleinputTextView);

        //Create an OnClickListener for the addPortalButton which navigates back
        //to the MainActivity.
        addPortalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mTitle = titleinputTextView.getText().toString();
                mURL = urlinputTextView.getText().toString();

                //Check if all the fields have been filled (else Snackbar).
                if(TextUtils.isEmpty(mTitle) || TextUtils.isEmpty(mURL)){
                    Snackbar.make(getCurrentFocus(),"Fill in all fields.", Snackbar.LENGTH_SHORT).show();
                    return;
                }

                //Put the data which is added to the intent.
                Intent data = new Intent();
                data.putExtra(EXTRA_TITLE,mTitle);
                data.putExtra(EXTRA_URL,mURL);
                setResult(RESULT_OK,data);
                finish();
            }
        });

    }
}
