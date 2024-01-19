package com.example.studybuddy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.studybuddy.databinding.ActivityFindSessionBinding;

import java.util.List;
import java.util.concurrent.ExecutorService;

public class FindSessionActivity extends AppCompatActivity {

    //CourseViewModel viewModel;
    ActivityFindSessionBinding binding;

    Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(@NonNull Message msg) {
            List<Course> data = (List<Course>) msg.obj;
            ArrayAdapter<Course> adp = new ArrayAdapter<Course>(FindSessionActivity.this,
                    R.layout.spinner_item, data);


            //binding.spinnerSession.setAdapter(adp);
            Spinner spinnerSession = binding.spinnerSession;
            spinnerSession.setAdapter(adp);
            //adp.notifyDataSetChanged();
            return true;
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = ActivityFindSessionBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        getSupportActionBar().setTitle("Select Course");

        Repo repo = new Repo();
        ExecutorService srv = ((WebApplication) getApplicationContext()).srv;
        repo.getCourses(srv,handler);

        Button buttonViewSessions = binding.buttonViewSessions;

        buttonViewSessions.setOnClickListener(v -> {




            String selectedCourse = binding.spinnerSession.getSelectedItem().toString();
            String courseCode = selectedCourse.substring(0, selectedCourse.indexOf(" "));
            Bundle bundle = new Bundle();
            bundle.putString("cc", courseCode);
            Intent i = new Intent(FindSessionActivity.this, EntryByCourseActivity.class);
            i.putExtras(bundle);
            startActivity(i);


        });

    }
}