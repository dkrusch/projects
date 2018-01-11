package com.danielkrusch.backup.youtubeish;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeStandalonePlayer;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonSingle = (Button) findViewById(R.id.btnSingle);
        Button buttonStandalone = (Button) findViewById(R.id.btnStand);

        buttonSingle.setOnClickListener(this);
        buttonStandalone.setOnClickListener(this);

//        View.OnClickListener listener = new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View view)
//            {
//
//            }
//        };
//
//        buttonVideo.setOnClickListener(listener);
//        buttonPlaylist.setOnClickListener(listener);
    }

    public void onClick(View view)
    {
        Intent intent = null;

        switch(view.getId())
        {
            case R.id.btnSingle:
                intent = new Intent(this, YoutubeActivity.class);
                break;
            case R.id.btnStand:
                intent = new Intent(this, StandaloneActivity.class);
                break;

            default:
        }

        if (intent != null)
        {
            startActivity(intent);
        }
    }
}
