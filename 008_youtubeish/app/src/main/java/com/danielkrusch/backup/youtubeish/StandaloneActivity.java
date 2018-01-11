package com.danielkrusch.backup.youtubeish;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeStandalonePlayer;

/**
 * Created by Backup on 1/11/2018.
 */

public class StandaloneActivity extends AppCompatActivity implements View.OnClickListener
{
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standalone);

        Button buttonVideo = (Button) findViewById(R.id.btnVideo);
        Button buttonPlaylist = (Button) findViewById(R.id.btnPlaylist);

        buttonVideo.setOnClickListener(this);
        buttonPlaylist.setOnClickListener(this);

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
            case R.id.btnVideo:
                intent = YouTubeStandalonePlayer.createVideoIntent(this,YoutubeActivity.GOOGLE_API_KEY, YoutubeActivity.YOUTUBE_VIDEO_ID, 0, true, true);
                break;
            case R.id.btnPlaylist:
                intent = YouTubeStandalonePlayer.createPlaylistIntent(this, YoutubeActivity.GOOGLE_API_KEY, YoutubeActivity.YOUTUBE_PLAYLIST, 1, 0, true, true);
                break;

            default:
        }

        if (intent != null)
        {
            startActivity(intent);
        }
    }
}
