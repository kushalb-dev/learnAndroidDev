package com.hfad.dynamicfragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class StopwatchActivityFragment extends Fragment {

    private static final String ARG_SECONDS_COUNT = "seconds_count";
    private static final String ARG_RUNNING_STATUS = "running";
    private static final String ARG_WAS_RUNNING_STATUS = "was_running";

    private int secondsCount;
    private boolean running;
    private boolean wasRunning;

    public StopwatchActivityFragment() {
        // Required empty public constructor
    }

    public static StopwatchActivityFragment newInstance() {
        StopwatchActivityFragment fragment = new StopwatchActivityFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECONDS_COUNT, 0);
        args.putBoolean(ARG_RUNNING_STATUS, false);
        args.putBoolean(ARG_WAS_RUNNING_STATUS, false);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            secondsCount = savedInstanceState.getInt(ARG_SECONDS_COUNT, 0);
            running = savedInstanceState.getBoolean(ARG_RUNNING_STATUS, false);
            wasRunning = savedInstanceState.getBoolean(ARG_WAS_RUNNING_STATUS, false);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        wasRunning = running;
        running = false;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (wasRunning) {
            running = true;
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt(ARG_SECONDS_COUNT, secondsCount);
        outState.putBoolean(ARG_RUNNING_STATUS, running);
        outState.putBoolean(ARG_WAS_RUNNING_STATUS, wasRunning);
    }

    private void runTimer(TextView timeView) {
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = secondsCount / 3600;
                int minutes = (secondsCount % 3600) / 60;
                int secs = secondsCount % 60;
                String time = String.format(Locale.getDefault(), "%d:%02d:%02d", hours, minutes, secs);
                timeView.setText(time);
                if (running) {
                    secondsCount++;
                }
                handler.postDelayed(this, 1000);
            }
        });
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView timeView = view.findViewById(R.id.time_view);
        Button startButton = view.findViewById(R.id.start_button);
        Button stopButton = view.findViewById(R.id.stop_button);
        Button resetButton = view.findViewById(R.id.reset_button);

        startButton.setOnClickListener(v -> running = true);

        stopButton.setOnClickListener(v -> running = false);

        resetButton.setOnClickListener(v -> {
            running = false;
            secondsCount = 0;
        });

        runTimer(timeView);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_stopwatch_activity, container, false);
    }
}