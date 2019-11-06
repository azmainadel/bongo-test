package com.xyntherys.bongovideoplayer;

import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String VIDEO_SAMPLE = "sample_video";
    private VideoView mVideoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

    }

    private void initView() {
        mVideoView = findViewById(R.id.videoview);
    }

    private void initPlayer() {
        Uri videoUri = getMedia(VIDEO_SAMPLE);
        mVideoView.setVideoURI(videoUri);

        mVideoView.start();
    }

    private void stopPlayer(){
        mVideoView.stopPlayback();
    }

    private Uri getMedia(String mediaName) {
        return Uri.parse("android.resource://" + getPackageName() +
                "/raw/" + mediaName);
    }

    @Override
    protected void onStart() {
        super.onStart();

        initPlayer();
    }

    @Override
    protected void onStop() {
        super.onStop();

        stopPlayer();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
            mVideoView.pause();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
