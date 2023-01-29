package com.example.programmingassignment;

import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.annotation.RequiresApi;

import android.widget.Toast;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.programmingassignment.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    private ToggleButton toggleButton;
    private TextView onOff;
    private int count = 0;
    Context context;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });

        //Additional Added Button
        binding.buttonFirst2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finish();
                System.exit(0);
            }
        });

        //Added Toggle Button to serve as counter taking in user input into application
        binding.toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    count++;
                    binding.toggleButton.setTextOn(Integer.toString(count));
                    if (count % 10 == 0) {

                        sendNotification();
                        //System.out.println("test");
                    }
                } else {
                    count++;
                    binding.toggleButton.setTextOff(Integer.toString(count));
                    if (count % 10 == 0) {
                        Toast.makeText(getActivity().getApplicationContext(), "Counted " + count + " Numbers", Toast.LENGTH_SHORT).show();

                        sendNotification();
                        //System.out.println("test");
                    }
                }
            }
        });
    }
    private void sendNotification() {
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(getContext());
        mBuilder.setSmallIcon(android.R.color.transparent);
        mBuilder.setContentTitle("Test Notification!");
        mBuilder.setContentText("Does this work?");
        mBuilder.setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat mNotificationManager = NotificationManagerCompat.from(getContext());
        //mNotificationManager.notify();
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}