package com.oakton.cis258.homework_12_gregmarsh;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;

public class Date3Activity extends UserInfo
{
    // Variables
    SharedPreferences spUserInfo;
    DatePicker dpBirthday;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date3);

        // Instantiate Shared Prefs.
        spUserInfo = getSharedPreferences(USER_INFO, Context.MODE_PRIVATE);

        // Instantiate Editor.
        final SharedPreferences.Editor editor = spUserInfo.edit();

        // Variables
        dpBirthday = (DatePicker) findViewById(R.id.datePicker);

        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // Store Text
                editor.putInt(BIRTH_DAY, dpBirthday.getDayOfMonth());
                int intCalendarMonth = dpBirthday.getMonth() + 1;
                editor.putInt(BIRTH_MONTH, intCalendarMonth);

                // Execute the code to save changes.
                editor.commit();

                Intent switchActivity = new Intent(Date3Activity.this, Favorites4Activity.class);
                startActivity(switchActivity);
                finish();
            }
        });

    }
}

