package com.example.backup.myresume;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

// This test
public class MainActivity extends AppCompatActivity
{
    Button workHistoryButton;
    Button callButton;
    Button emailButton;
    Button educationHistoryButton;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        workHistoryButton = (Button) findViewById(R.id.btnWK);
        callButton = (Button) findViewById(R.id.btnCall);
        emailButton = (Button) findViewById(R.id.btnEmail);
        educationHistoryButton = (Button) findViewById(R.id.btnEd);

        workHistoryButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent goToTheOtherActivity = new Intent(getApplicationContext(), WorkHistory.class);
                startActivity(goToTheOtherActivity);
            }
        });

        educationHistoryButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent goToTheOtherActivity = new Intent(getApplicationContext(), EducationHistory.class);
                startActivity(goToTheOtherActivity);
            }
        });

        workHistoryButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent goToTheOtherActivity = new Intent(getApplicationContext(), WorkHistory.class);
                startActivity(goToTheOtherActivity);
            }
        });

        callButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Uri myPhoneNumber = Uri.parse("tel:18284073772");
                Intent callIntent = new Intent(Intent.ACTION_DIAL, myPhoneNumber);
                startActivity(callIntent);
            }
        });

        emailButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setType("plain/text");
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {"daniel.krusch@gmail.com"});
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Man's resume.");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "I really like your resume!");
                startActivity(emailIntent);

                startActivity(emailIntent);
            }
        });
    }
}
