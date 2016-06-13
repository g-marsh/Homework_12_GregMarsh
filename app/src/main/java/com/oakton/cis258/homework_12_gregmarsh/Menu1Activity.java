package com.oakton.cis258.homework_12_gregmarsh;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Menu1Activity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu1);

        // Navigation Options
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent switchActivity = new Intent(Menu1Activity.this, UserInfo2Activity.class);
                startActivity(switchActivity);
                finish();
            }
        });

        findViewById(R.id.button6).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent switchActivity = new Intent(Menu1Activity.this, Favorites4Activity.class);
                startActivity(switchActivity);
                finish();
            }
        });

        findViewById(R.id.button7).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent switchActivity = new Intent(Menu1Activity.this, View5Activity.class);
                startActivity(switchActivity);
                finish();
            }
        });

    }
}
