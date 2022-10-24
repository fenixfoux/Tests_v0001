package com.example.tests_v0001;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import java.lang.ref.WeakReference;

public class Registration extends AppCompatActivity {

    private EditText u_fName, u_lName, u_login, u_pass_ne, u_pass_encrypt, u_email, u_phone;
    private UserDatabase userDatabase;
    private User user;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_registration);

        u_fName = findViewById(R.id.user_firstName);
        u_lName = findViewById(R.id.user_lastName);
        u_login = findViewById(R.id.user_login);
        u_pass_ne = findViewById(R.id.user_password);
        //u_pass_encrypt = findViewById(R.id.user_password);
        u_email = findViewById(R.id.user_email);
        u_phone = findViewById(R.id.user_phone);

        userDatabase = UserDatabase.getInstance(Registration.this);
        Button butt_save = findViewById(R.id.button_save);

            butt_save.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // fetch data and create note object
                    user = new User(
                            u_fName.getText().toString(),
                            u_lName.getText().toString(),
                            u_login.getText().toString(),
                            u_pass_ne.getText().toString(),
                            u_email.getText().toString(),
                            u_phone.getText().toString()
                    );
                    // create worker thread to insert data into database
                    new InsertTask(Registration.this, user).execute();
                }
            });

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

    private void setResult() {
        for (User user: userDatabase.getDAO_User().getAll()) {
            Toast.makeText(this, user.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    private static class InsertTask extends AsyncTask<Void,Void,Boolean> {

        private WeakReference<Registration> activityReference;
        private User user;

        // only retain a weak reference to the activity
        InsertTask(Registration context, User user) {
            activityReference = new WeakReference<>(context);
            this.user = user;
        }

        // doInBackground methods runs on a worker thread
        @Override
        protected Boolean doInBackground(Void... objs) {
            activityReference.get().userDatabase.getDAO_User().insert(user);
            return true;
        }

        // onPostExecute runs on main thread
        @Override
        protected void onPostExecute(Boolean bool) {
            if (bool){
                activityReference.get().setResult();
            }
        }

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
