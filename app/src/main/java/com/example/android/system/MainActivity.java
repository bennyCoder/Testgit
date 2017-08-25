package com.example.android.system;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {





    private EditText editUsername;
    private EditText editPassword;
    private Button buttonRegister;
    private TextView textViewSignUp;
    private ProgressDialog progressDialog;

    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressDialog = new ProgressDialog(this);

        firebaseAuth = FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser()!=null)
        {

            finish();
            startActivity(new Intent(getApplicationContext(),Profile.class));

        }


        buttonRegister = (Button) findViewById(R.id.register);
        editUsername = (EditText) findViewById(R.id.email);

        editPassword = (EditText) findViewById(R.id.password);
        textViewSignUp = (TextView)findViewById(R.id.textSignUp);

        buttonRegister.setOnClickListener(this);
        textViewSignUp.setOnClickListener(this);

    }


    private void userRegitration() {

        String uName = editUsername.getText().toString().trim();

        String passW = editPassword.getText().toString().trim();


        if (TextUtils.isEmpty(uName)) {
            Toast.makeText(this, "Enter email it shoud not be empty", Toast.LENGTH_LONG).show();

            return;


        }
        if (TextUtils.isEmpty(passW)) {

            Toast.makeText(this, "Enter password it shoud not be empty", Toast.LENGTH_LONG).show();


            return;
        }


        progressDialog.setMessage("User registration in progress");

        progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(uName,passW).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {


                if (task.isSuccessful()) {


                    Toast.makeText(MainActivity.this, "Registration is complete", Toast.LENGTH_LONG).show();


                    progressDialog.dismiss();
                }
                else {
                    Toast.makeText(MainActivity.this, "Registration has failed", Toast.LENGTH_LONG).show();

                }
            }
        });


    }

    @Override
    public void onClick(View view) {

        if (view == buttonRegister) {


            userRegitration();


        }
        if (view == textViewSignUp) {
          startActivity(new Intent(this ,Login.class));
        }
    }



}

