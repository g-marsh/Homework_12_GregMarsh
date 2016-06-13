package com.oakton.cis258.homework_12_gregmarsh;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Spinners4BActivity extends UserInfo
{
    // Variables
    SharedPreferences spUserInfo;
    Spinner spnColor;
    Spinner spnMovieGenre;
    String strColor;
    String strMovieGenre;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinners4_b);

        // Instantiate Shared Prefs.
        spUserInfo = getSharedPreferences(USER_INFO, Context.MODE_PRIVATE);

        // Instantiate Editor.
        final SharedPreferences.Editor editor = spUserInfo.edit();

        // Variables
        spnColor = (Spinner) findViewById(R.id.spinner);
        spnMovieGenre = (Spinner) findViewById(R.id.spinner2);

        // Instantiate Spinners Method.
        addItemsSpinnerColor();
        addItemsSpinnerMovieGenre();


        findViewById(R.id.button5).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                strColor = String.valueOf(spnColor.getSelectedItem());
                strMovieGenre = String.valueOf(spnMovieGenre.getSelectedItem());
                // Store Info into shared preferences and switch activity
                editor.putString(COLOR, strColor);
                editor.putString(MOVIE_GENRE, strMovieGenre);

                // Execute the code to save changes.
                editor.commit();
                Intent switchActivity = new Intent(Spinners4BActivity.this, View5Activity.class);
                startActivity(switchActivity);
                finish();
            }
        });

    }

    // Setup the Color Spinner.
    public void addItemsSpinnerColor()
    {
        // Declare and populate array
        String [] aryColor = getResources().getStringArray(R.array.color);

        // Bind the array to the Spinner.
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, aryColor);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the settings to the Spinner.
        spnColor.setAdapter(dataAdapter);
    }

    // Setup the Color Spinner.
    public void addItemsSpinnerMovieGenre()
    {
        // Declare and populate array
        String [] aryMovieGenre = getResources().getStringArray(R.array.movie_genre);

        // Bind the array to the Spinner.
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, aryMovieGenre);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the settings to the Spinner.
        spnMovieGenre.setAdapter(dataAdapter);
    }

}
