package com.hfad.dynamicfragments;

import static androidx.fragment.app.FragmentTransaction.TRANSIT_FRAGMENT_FADE;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentWorkoutDetail extends Fragment {

    private static final String ARG_WORKOUT_ID = "workout_id";
    private long workoutId;

    public FragmentWorkoutDetail() {
        // Required empty public constructor
    }

    public static FragmentWorkoutDetail newInstance(long workoutId) {
        FragmentWorkoutDetail fragment = new FragmentWorkoutDetail();
        Bundle args = new Bundle();
        args.putLong(ARG_WORKOUT_ID, workoutId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            workoutId = getArguments().getLong(ARG_WORKOUT_ID);
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Workout workout = Workout.workouts[(int) workoutId];
        ((TextView) view.findViewById(R.id.workout_title)).setText(workout.getName());
        ((TextView) view.findViewById(R.id.workout_description)).setText(workout.getDescription());
        if (savedInstanceState == null) {
            StopwatchActivityFragment stopwatchActivityFragment = StopwatchActivityFragment.newInstance();
            getChildFragmentManager().beginTransaction()
                    .replace(R.id.stopwatch_container, stopwatchActivityFragment)
                    .setTransition(TRANSIT_FRAGMENT_FADE)
                    .commit();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_workout_detail, container, false);
    }
}