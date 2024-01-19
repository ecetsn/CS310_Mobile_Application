package com.example.studybuddy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.studybuddy.databinding.ActivitySaveUserBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

public class SaveUserActivity extends AppCompatActivity {

    Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(@NonNull Message msg) {

            return true;
        }
    });

    ActivitySaveUserBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySaveUserBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().setTitle("Save User");



        List<String> eduClassList = new ArrayList<>();
        eduClassList.add("Prep");
        eduClassList.add("Freshman");
        eduClassList.add("Sophomore");
        eduClassList.add("Junior");
        eduClassList.add("Senior");

        ArrayAdapter<String> adp = new ArrayAdapter<>(this, R.layout.spinner_item, eduClassList);

        Spinner spClass = binding.spnClass;
        spClass.setAdapter(adp);

        TextView txtUsername = binding.txtUserName;
        TextView txtUserGpa = binding.txtUserGpa;


        Button btn = binding.btnSaveUser;
        btn.setOnClickListener(v->{

            String saveName = txtUsername.getText().toString();
            String saveClass = spClass.getSelectedItem().toString();
            String saveGpa = txtUserGpa.getText().toString();
            Repo repo = new Repo();
            ExecutorService srv = ((WebApplication) getApplicationContext()).srv;
            repo.saveUser(srv,handler, saveName, saveClass, saveGpa);

            String output = "Saved user " + saveName + " to the database";
            // Create Toast
            Toast toast = Toast.makeText(SaveUserActivity.this, output, Toast.LENGTH_SHORT);

            // Change Toast Appearance
            ViewGroup group = (ViewGroup) toast.getView();
            TextView message = (TextView) group.getChildAt(0);
            message.setTextSize(25);
            TextView toastMessage = toast.getView().findViewById(android.R.id.message);
            toastMessage.setGravity(Gravity.CENTER);

            toast.show();
            finish();
        });





    }
}