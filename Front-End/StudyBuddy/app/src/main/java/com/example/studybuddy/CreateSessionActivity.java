package com.example.studybuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.studybuddy.databinding.ActivityCreateSessionBinding;

import java.util.concurrent.ExecutorService;

public class CreateSessionActivity extends AppCompatActivity {

    ActivityCreateSessionBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCreateSessionBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        getSupportActionBar().setTitle("Create Study Session");

        Button btnCreate = binding.buttonCreate;

        TextView txtUsername = binding.textNameSurname;
        TextView txtSesDate = binding.textDate ;
        TextView txtLocation = binding.textLocation ;
        TextView txtCourseCode = binding.textCourse ;
        TextView txtDesc = binding.textDes ;


        btnCreate.setOnClickListener(v->{

            String saveName = txtUsername.getText().toString();
            String sesDate = txtSesDate.getText().toString();
            String location = txtLocation.getText().toString();
            String courseCode = txtCourseCode.getText().toString();
            String description = txtDesc.getText().toString();

            Repo repo = new Repo();
            ExecutorService srv = ((WebApplication) getApplicationContext()).srv;


            repo.saveEntry(srv, saveName,courseCode, location,  sesDate, description);

            String output = "Saved entry by " + saveName + " to the database";
            Toast toast = Toast.makeText(CreateSessionActivity.this, output, Toast.LENGTH_SHORT);


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