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
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity implements View.OnClickListener{

    private EditText editEmail;
    private EditText editPassW;
    private Button buttonSignUp;
    private TextView textViewSignUp;
    private ProgressDialog progressDialog;


FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        progressDialog = new ProgressDialog(this);

        firebaseAuth = FirebaseAuth.getInstance();

       if(firebaseAuth.getCurrentUser()!=null)
        {

            finish();
            startActivity(new Intent(getApplicationContext(),Profile.class));


        }

        buttonSignUp = (Button) findViewById(R.id.SignUp);

        editEmail = (EditText) findViewById(R.id.email_);

        editPassW= (EditText) findViewById(R.id.password_);
        textViewSignUp = (TextView)findViewById(R.id.textSignUp);

        buttonSignUp.setOnClickListener(this);
       // textViewSignUp.setOnClickListener(this);


    }
private void userLongIn()
{

 String emails = editEmail.getText().toString().trim();
    String passWords = editPassW.getText().toString().trim();

    if (TextUtils.isEmpty(emails)) {
        Toast.makeText(this, "Enter email it shoud not be empty", Toast.LENGTH_LONG).show();

        return;


    }
    if (TextUtils.isEmpty(passWords)) {

        Toast.makeText(this, "Enter password it shoud not be empty", Toast.LENGTH_LONG).show();


        return;
    }

    progressDialog.setMessage(" singing in progress");

    progressDialog.show();

    firebaseAuth.signInWithEmailAndPassword(emails,passWords).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
        @Override
        public void onComplete(@NonNull Task<AuthResult> task) {

            if (task.isSuccessful()) {
                 finish();
                startActivity(new Intent(getApplicationContext(),Profile.class));

                Toast.makeText(Login.this, "Login successful", Toast.LENGTH_LONG).show();
                progressDialog.dismiss();
            }
            else
            {

                Toast.makeText(Login.this, "Login failed", Toast.LENGTH_LONG).show();
            }

        }
    });

}
    @Override
    public void onClick(View view) {


        if (view == buttonSignUp) {


            userLongIn();


        }
     if (view == textViewSignUp) {
            finish();
              startActivity(new Intent(this,Login.class));}



    }
}
