package com.example.studybuddy;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

public class Repo {
    String localIP = "192.168.0.209";

    public void getCourses(ExecutorService srv, Handler uiHandler) {
        srv.execute(() -> {
            try {
                URL url = new URL("http://" + localIP + ":8080/studybuddy/course" );
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();

                BufferedInputStream reader = new BufferedInputStream(conn.getInputStream());
                StringBuilder buffer = new StringBuilder();
                int chr = 0;
                while ((chr = reader.read()) != -1) {
                    buffer.append((char) chr);
                }

                JSONArray arr = new JSONArray(buffer.toString());
                List<Course> data = new ArrayList<>();
                for (int i = 0; i < arr.length(); i++) {
                    JSONObject currentObj = arr.getJSONObject(i);
                    data.add(new Course(currentObj.getString("name"),
                            currentObj.getString("code"), currentObj.getString("id")));
                }

                Message msg = new Message();
                msg.obj = data;
                uiHandler.sendMessage(msg);

            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }

        });
    }
    public void saveUser(ExecutorService srv, Handler uiHandler, String name, String educlass, String GPA){
        srv.execute(()->{

            try {
                double dGPA = Double.parseDouble(GPA);
                URL url = new URL("http://" + localIP + ":8080/studybuddy/users/save");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();

                conn.setDoInput(true);
                conn.setDoOutput(true);


                conn.setRequestMethod("POST");
                conn.setRequestProperty("Content-Type", "application/JSON");

                JSONObject objtoSend = new JSONObject();
                objtoSend.put("name", name);
                objtoSend.put("educlass", educlass);
                objtoSend.put("gpa", dGPA);


                BufferedOutputStream writer = new BufferedOutputStream(conn.getOutputStream());

                writer.write(objtoSend.toString().getBytes(StandardCharsets.UTF_8));
                writer.flush();

                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                StringBuilder buffer = new StringBuilder();
                String line = "";

                while((line=reader.readLine())!=null)
                {
                    buffer.append(line);
                }

            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }


        });

    }
    public void saveEntry(ExecutorService srv, String name, String course, String Location, String sesDate, String Desc){
        LocalDate now;
        LocalDate sessionDate;

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            now = LocalDate.now();
            sessionDate = LocalDate.parse(sesDate);
        } else {
            now = null;
            sessionDate = null;
        }
        srv.execute(()->{

            try {
                // Find Course Object by Course Code
                URL helperURL = new URL("http://" + localIP + ":8080/studybuddy/" + course);
                HttpURLConnection helperConn = (HttpURLConnection) helperURL.openConnection();


                BufferedReader reader_ = new BufferedReader (
                                            new InputStreamReader(
                                                    helperConn.getInputStream()));

                StringBuilder buffer = new StringBuilder();
                String line="";
                while ((line=reader_.readLine())!=null) {
                    buffer.append(line);
                }
                JSONObject currCourse  = new JSONObject(buffer.toString());


                // Find User Object by User Name
                helperURL = new URL("http://" + localIP + ":8080/studybuddy/users/" + name);
                helperConn = (HttpURLConnection) helperURL.openConnection();

                reader_ = new BufferedReader (
                        new InputStreamReader(
                                helperConn.getInputStream()));
                StringBuilder buffer2 = new StringBuilder();
                line = "";
                while ((line=reader_.readLine())!=null) {
                    buffer2.append(line);
                }
                JSONObject currUser  = new JSONObject(buffer2.toString());


                URL url = new URL("http://" + localIP + ":8080/studybuddy/entry/save");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();

                conn.setDoInput(true);
                conn.setDoOutput(true);

                conn.setRequestMethod("POST");
                conn.setRequestProperty("Content-Type", "application/JSON");

                JSONObject objtoSend = new JSONObject();

                objtoSend.put("location", Location);
                objtoSend.put("description", Desc);
                objtoSend.put("dateStudy", sessionDate);
                objtoSend.put("dateCreate", now);
                objtoSend.put("course", currCourse);
                objtoSend.put("user", currUser);


                BufferedOutputStream writer = new BufferedOutputStream(conn.getOutputStream());

                writer.write(objtoSend.toString().getBytes(StandardCharsets.UTF_8));
                writer.flush();

                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                buffer = new StringBuilder();
                while((line = reader.readLine())!= null)
                {
                    buffer.append(line);
                }

                JSONObject deneme = new JSONObject(buffer.toString());

            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }

        });


    }
    public void getCourseEntries(ExecutorService srv, Handler uiHandler, String course){
        srv.execute(()->{
            try {
                URL url = new URL("http://" + localIP + ":8080/studybuddy/" + course + "/entry");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();

                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                StringBuilder buffer = new StringBuilder();
                String line = "";

                while((line=reader.readLine())!=null)
                {
                    buffer.append(line);
                }

                JSONArray arr = new JSONArray(buffer.toString());
                List<Entry> data = new ArrayList<>();
                for (int i = 0; i < arr.length(); i++) {
                    LocalDate dateStudy;
                    LocalDate dateCreate;
                    JSONObject currentObj = arr.getJSONObject(i);
                    String id = currentObj.get("id").toString();
                    String location = currentObj.get("location").toString();
                    String description = currentObj.get("description").toString();
                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                        dateStudy = LocalDate.parse(currentObj.get("dateStudy").toString());
                        dateCreate = LocalDate.parse(currentObj.get("dateCreate").toString());
                    }

                    else {
                        dateStudy = null;
                        dateCreate = null;
                    }

                    JSONObject courseJSON = currentObj.getJSONObject("course");
                    Course courseOBJ = new Course(
                            courseJSON.getString("name"),
                            courseJSON.getString("code"),
                            courseJSON.getString("id")
                    );


                    JSONObject userJSON = currentObj.getJSONObject("user");
                    User userOBJ = new User(
                            userJSON.getString("id"),
                            userJSON.getString("name"),
                            userJSON.getString("educlass"),
                            userJSON.getDouble("gpa")

                    );

                    data.add(new Entry(
                            id, location, description, courseOBJ, userOBJ, dateStudy, dateCreate
                    ));

                }



                Message msg = new Message();
                msg.obj = data;

                uiHandler.sendMessage(msg);

            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }

        });
    }
}
