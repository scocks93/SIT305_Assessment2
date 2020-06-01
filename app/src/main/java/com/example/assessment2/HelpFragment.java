package com.example.assessment2;

import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

public class HelpFragment extends Fragment {

    private static final String VIDEO_SAMPLE = "tempvideo";
    private static VideoView videoView;
    private static int mCurrentPosition = 0;
    private static int mStatePosition = 0;
    private static final String PLAYBACK_TIME = "play_time";

    private Uri getMedia (String mediaName) {
        return Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.tempvideo);
    }

    private void initializePlayer() {
        Uri videoUri = getMedia(VIDEO_SAMPLE);
        videoView.setVideoURI(videoUri);

        // If the video has already been playing, set current position back to that point
        if (mCurrentPosition > 0) {
            videoView.seekTo(mCurrentPosition);
        }
        else {
            videoView.seekTo(1);
        }

        videoView.start();
    }

    private void releasePlayer() {
        videoView.stopPlayback();
    }

    public HelpFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle("Help");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_help, container, false);

        videoView = (VideoView) view.findViewById(R.id.videoView);

        // Check if there is a saved playback time, if so, set current position to saved playback time
        if (savedInstanceState != null) {
            mCurrentPosition = savedInstanceState.getInt(PLAYBACK_TIME);
        }

        // Add media controls to the video player
        MediaController mediaController = new MediaController(this.getActivity());
        mediaController.setMediaPlayer(videoView);
        videoView.setMediaController(mediaController);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        initializePlayer();
    }

    @Override
    public void onStop() {
        super.onStop();
        releasePlayer();
    }

    @Override
    public void onResume() {
        super.onResume();
        initializePlayer();
    }

    @Override
    public void onPause() {
        super.onPause();
        mStatePosition = videoView.getCurrentPosition();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(PLAYBACK_TIME, mStatePosition);
    }
}
