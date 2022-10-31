package com.example.tests_v0001;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private long backPressedTime;
    private Toast backToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.fragment_container_view, ExampleFragment.class, null)
                    .commit();
        }


        //Button bt_test_fragment = (Button)findViewById(R.id.button_test);

        //Button bt_test = (Button)findViewById(R.id.bt_test_fragment);
        /*
        Button bt_log = (Button)findViewById(R.id.button_log_in);
        bt_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToast = Toast.makeText(getBaseContext(), "log in button pressed", Toast.LENGTH_SHORT);
                backToast.show();
            }
        });
        Button bt_reg = (Button)findViewById(R.id.button_registration);
        bt_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(MainActivity.this, Registration.class);
                    startActivity(intent);
                    finish();
                }catch(Exception e){
                    //backToast = Toast.makeText(getBaseContext(), "Error: " + e, Toast.LENGTH_SHORT);
                    //backToast.show();
                    TextView error_text = (TextView)findViewById(R.id.txt_for_err);
                    error_text.setText("Error: " + e);
                    //error may be
                }
            }
        });
        */
    }


    @Override
    public void onBackPressed() {
        if( backPressedTime + 2000 > System.currentTimeMillis()){
            backToast.cancel();
            super.onBackPressed();
        }else{
            backToast = Toast.makeText(getBaseContext(), "press again for exit", Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressedTime = System.currentTimeMillis();
    }
}