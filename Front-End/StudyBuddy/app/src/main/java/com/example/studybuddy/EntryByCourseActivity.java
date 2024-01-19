package com.example.studybuddy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.example.studybuddy.databinding.ActivityEntryByCourseBinding;

import java.util.List;
import java.util.concurrent.ExecutorService;

public class EntryByCourseActivity extends AppCompatActivity {

    List<Entry> data;
    EntryAdapter adp;

    Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(@NonNull Message msg) {
            List<Entry> data = (List<Entry>) msg.obj;

            adp = new EntryAdapter(EntryByCourseActivity.this, data);


            String output = "";
            if(data.size() == 0) {
                output = "There are no entries for this course";}
            else{ output = "Entry Count: " + data.size();}

            binding.recViewEntry.setAdapter(adp);

            return true;
        }
    });
    ActivityEntryByCourseBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = ActivityEntryByCourseBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        String courseCode = getIntent().getStringExtra("cc");

        binding.recViewEntry.setLayoutManager(new LinearLayoutManager(this));


        getSupportActionBar().setTitle("Entries for Course: " + courseCode);

        Repo repo = new Repo();
        ExecutorService srv = ((WebApplication)getApplication()).srv;
        repo.getCourseEntries(srv, handler, courseCode);
    }
}