package com.example.studybuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.example.studybuddy.databinding.ActivityMainBinding;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        getSupportActionBar().hide();
        setContentView(binding.getRoot());


        Button buttonFindSession = binding.buttonFindSession;

        buttonFindSession.setOnClickListener(v->{

            Intent i = new Intent(MainActivity.this,
                    FindSessionActivity.class);
            startActivity(i);

        });

        Button buttonCreateSession= binding.buttonCreateSession;

        buttonCreateSession.setOnClickListener(v->{

            Intent i = new Intent(MainActivity.this,
                    CreateSessionActivity.class);
            startActivity(i);

        });
        // ExecutorService srv yaptıktan sonra Manifest içinde app içinde name = class belirt
        Button buttonSaveUser = binding.buttonSaveUser;
        buttonSaveUser.setOnClickListener(v->{

            Intent i = new Intent(MainActivity.this,
                    SaveUserActivity.class);
            startActivity(i);

        });

    }




}