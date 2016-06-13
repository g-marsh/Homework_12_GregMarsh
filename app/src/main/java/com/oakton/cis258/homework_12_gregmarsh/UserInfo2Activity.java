package com.oakton.cis258.homework_12_gregmarsh;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class UserInfo2Activity extends UserInfo
{
    // Variables
    SharedPreferences spUserInfo;
    EditText etFirstName;
    EditText etUsername;
    EditText etEmail;
    EditText etHometown;
    RadioButton rbFemale;
    boolean blnFemale;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info2);

        // Instantiate Shared Prefs.
        spUserInfo = getSharedPreferences(USER_INFO, Context.MODE_PRIVATE);

        // Instantiate Editor.
        final SharedPreferences.Editor editor = spUserInfo.edit();

        // Variables
        etFirstName = (EditText)findViewById(R.id.editText);
        etUsername = (EditText)findViewById(R.id.editText2);
        etEmail = (EditText)findViewById(R.id.editText3);
        etHometown = (EditText)findViewById(R.id.editText4);
        rbFemale = (RadioButton) findViewById(R.id.radioButton);


        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String strFirstName = String.valueOf(etFirstName.getText());
                String strUsername = String.valueOf(etUsername.getText());
                String strEmail = String.valueOf(etEmail.getText());
                String strHometown = String.valueOf(etHometown.getText());
                if(rbFemale.isChecked())
                {
                    blnFemale = true;
                }
                else
                {
                    blnFemale = false;
                }

                editor.putString(FIRST_NAME,strFirstName);
                editor.putString(USER_NAME, strUsername);
                editor.putString(EMAIL, strEmail);
                editor.putString(HOMETOWN, strHometown);
                editor.putBoolean(FEMALE, blnFemale);

                // Execute the code to save changes.
                editor.commit();

                Intent switchActivity = new Intent(UserInfo2Activity.this, Date3Activity.class);
                startActivity(switchActivity);
                finish();
            }
        });
    }
}
