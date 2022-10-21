package com.example.tests_v0001;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Registration extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_registration);

        Button go_to_login = (Button)findViewById(R.id.button_log_in);
        go_to_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Intent intent = new Intent(Registration.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } catch (Exception ex){}
            }
        });

    }




    @Override
    public void onBackPressed(){
        try {
            Intent intent = new Intent (Registration.this, MainActivity.class);
            startActivity(intent);
            finish();//close window
        }catch (Exception e){}
    }
}
