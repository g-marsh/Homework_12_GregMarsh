package com.oakton.cis258.homework_12_gregmarsh;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class View5Activity extends UserInfo
{
    // Variables
    SharedPreferences spUserInfo;
    TextView tvFirstName;
    TextView tvBirthDay;
    TextView tvSport;
    TextView tvColor;
    TextView tvMovieGenre;
    TextView tvUsername;
    TextView tvEmail;
    TextView tvGender;
    TextView tvHometown;
    boolean blnFemale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view5);

        // Instantiate variables
        spUserInfo = getSharedPreferences(USER_INFO, Context.MODE_PRIVATE);
        tvFirstName = (TextView)findViewById(R.id.textView6);
        tvBirthDay = (TextView)findViewById(R.id.textView9);
        tvSport = (TextView)findViewById(R.id.textView12);
        tvColor = (TextView)findViewById(R.id.textView16);
        tvMovieGenre = (TextView)findViewById(R.id.textView18);
        tvUsername = (TextView) findViewById(R.id.textView20);
        tvEmail = (TextView) findViewById(R.id.textView22);
        tvGender = (TextView) findViewById(R.id.textView24);
        tvHometown = (TextView) findViewById(R.id.textView26);

        // Read UserInfo and update Text
        tvFirstName.setText(spUserInfo.getString(FIRST_NAME, ""));
        tvUsername.setText(spUserInfo.getString(USER_NAME, ""));
        tvEmail.setText(spUserInfo.getString(EMAIL, ""));
        blnFemale = spUserInfo.getBoolean(FEMALE, false);
        if (blnFemale)
        {
            tvGender.setText(R.string.female);
        }
        else
        {
            tvGender.setText(R.string.male);
        }
        tvHometown.setText(spUserInfo.getString(HOMETOWN, ""));
        tvSport.setText(spUserInfo.getString(SPORT, ""));
        tvColor.setText(spUserInfo.getString(COLOR, ""));
        tvMovieGenre.setText(spUserInfo.getString(MOVIE_GENRE, ""));
        String StrBirthDay = String.valueOf(spUserInfo.getInt(BIRTH_DAY, 0));
        String StrBirthMonth = String.valueOf(spUserInfo.getInt(BIRTH_MONTH, 0));
        tvBirthDay.setText(StrBirthMonth+"/"+StrBirthDay);

        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent switchActivity = new Intent(View5Activity.this, Menu1Activity.class);
                startActivity(switchActivity);
                finish();
            }
        });

    }
}
