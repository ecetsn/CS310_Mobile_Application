package com.example.studybuddy;

import android.app.Application;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WebApplication extends Application {
    ExecutorService srv = Executors.newCachedThreadPool();
}
