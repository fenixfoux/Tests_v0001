package com.example.tests_v0001;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //inflate part for log in
        LayoutInflater li = LayoutInflater.from(getApplicationContext());
        View view_log_in = li.inflate(R.layout.fragment_log_in, null);
        addContentView(view_log_in, null);
    }
}