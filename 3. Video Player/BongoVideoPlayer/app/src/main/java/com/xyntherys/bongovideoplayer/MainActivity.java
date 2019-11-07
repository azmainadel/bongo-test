package com.xyntherys.bongovideoplayer;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import com.xyntherys.bongovideoplayer.model.MediaFile;
import com.xyntherys.bongovideoplayer.util.MediaResource;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private VideoView mVideoView;
    private TextView mBufferingTextView;

    private int mCurrentPosition = 0;
    private static final String PLAYBACK_TIME = "play_time";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        if (savedInstanceState != null) {
            mCurrentPosition = savedInstanceState.getInt(PLAYBACK_TIME);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt(PLAYBACK_TIME, mVideoView.getCurrentPosition());
    }

    private void initView() {
        mVideoView = findViewById(R.id.videoview);
        mBufferingTextView = findViewById(R.id.buffering_textview);

        MediaController mController = new MediaController(this);
        mController.setMediaPlayer(mVideoView);
        mVideoView.setMediaController(mController);
    }

    private void initPlayer() {
        mBufferingTextView.setVisibility(VideoView.VISIBLE);

        ArrayList<MediaFile> mediaObjects =
                new ArrayList<>(Arrays.asList(MediaResource.VIDEO_FILES));

        Uri videoUri = Uri.parse(mediaObjects.get(0).getMedia_url());
        mVideoView.setVideoURI(videoUri);

        mVideoView.setOnPreparedListener(
                new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        mBufferingTextView.setVisibility(VideoView.INVISIBLE);

                        if (mCurrentPosition > 0) {
                            mVideoView.seekTo(mCurrentPosition);
                        } else {
                            mVideoView.seekTo(1);
                        }
                        mVideoView.start();
                    }
                });

        mVideoView.setOnCompletionListener(
                new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        Toast.makeText(MainActivity.this,
                                R.string.toast_message,
                                Toast.LENGTH_SHORT).show();
                        mVideoView.seekTo(0);
                    }
                });
    }

    private void stopPlayer() {
        mVideoView.stopPlayback();
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
