package com.example.mediaplayerapp;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    Button btPlay,btPause,btStop;

    MediaPlayer mediaPlayer = new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        btPlay = findViewById(R.id.btPlay);
        btPause = findViewById(R.id.btPause);
        btStop = findViewById(R.id.btStop);

        btPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
            }
        });

        btPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.pause();

            }
        });

        btStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.pause();
                mediaPlayer.seekTo(0);

            }
        });


        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

        MediaPlayer mediaPlayer1 = new MediaPlayer();

        mediaPlayer1.setAudioStreamType(AudioManager.STREAM_MUSIC);


        String audioUrl = "https://www.learningcontainer.com/wp-content/uploads/2020/02/Kalimba.mp3";

        Uri uriOnline = Uri.parse(audioUrl);

        findViewById(R.id.btUrlAudio).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mediaPlayer1.setDataSource(MainActivity.this,uriOnline);
                    mediaPlayer1.prepare();
                    mediaPlayer1.start();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        findViewById(R.id.btUrlAudio).setLongClickable(true);
        findViewById(R.id.btUrlAudio).setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent intent = new Intent(MainActivity.this,MainActivity.class);
                startActivity(intent);
                return true;
            }
        });



        String audioPath = "android.resource://"+getPackageName()+"/raw/win_audio";

        Uri audioUri = Uri.parse(audioPath);

        try {
            mediaPlayer.setDataSource(this,audioUri);
            mediaPlayer.prepare();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

//        this are some function under the mediaPlayer class

//        mediaPlayer.seekTo();
//        mediaPlayer.getDuration();
//        mediaPlayer.getCurrentPosition();
//        mediaPlayer.setLooping();
//        mediaPlayer.release();
//        mediaPlayer.reset();


//        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//            @Override
//            public void onCompletion(MediaPlayer mp) {
//
//            }
//        });


//        try {
//            mediaPlayer.prepare();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }
}