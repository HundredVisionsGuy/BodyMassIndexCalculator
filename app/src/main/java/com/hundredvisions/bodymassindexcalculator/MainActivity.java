package com.hundredvisions.bodymassindexcalculator;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {
    // Declare our UI objects
    EditText edit_feet, edit_inches, edit_pounds;
    Button button_calculate_bmi;
    TextView text_results;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // "Connect" the variables to the UI elements in content_main
        edit_feet = (EditText) findViewById(R.id.edit_feet);
        edit_inches = (EditText) findViewById(R.id.edit_inches);
        edit_pounds = (EditText) findViewById(R.id.edit_pounds);
        button_calculate_bmi = (Button) findViewById(R.id.button_calculate_bmi);
        text_results = (TextView) findViewById(R.id.text_results);

        button_calculate_bmi.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String results = "Results: ";
                int feet;
                // Checking feet for validation
                try {
                    feet = Integer.parseInt(edit_feet.getText().toString());
                    if (feet < 2 || feet >= 9) {
                        edit_feet.setError("Out of range!");
                        results += "You are either too tall or too short to be using" +
                                "this app.";
                    }
                } catch (Exception ex) {
                    Context context = getApplicationContext();
                    CharSequence text = "Feet was empty!";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
                text_results.setText(results);
            }
        });
    }
    /* public int calculateBMI(int inches, int pounds) {
        return 0;
    } */
}

