package com.example.android.system;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.messaging.FirebaseMessaging;

import java.util.ArrayList;
import java.util.List;

public class Profile extends AppCompatActivity implements View.OnClickListener {
   private FirebaseDatabase fUpdateProfile;
    private DatabaseReference dbRerence;
    private FirebaseAuth firebaseAuth;
    private TextView textUserEmail;
    private Button buttonLogOut;


    private String valid_name, valid_surname, valid_email, valid_streetname,
            valid_city, valid_areaname, valid_unitname, valid_phone,
            valid_cell;



    // for update purpose
    private Button upDateProfile;
    private Button part;
    private TextView textName;
    private TextView textSurname;
    private TextView textProvence;
    private TextView textCity;
    private TextView textAdress;
    private TextView textCellNo;
    private RadioButton rdM,rdF;
    private  RadioButton rdD,rdR;
    private RadioGroup radioGender;
    private RadioGroup radioParticipants;
     private  boolean message;
    private String ontainGender;
    private  String obainParticipants;
  private  boolean valid = true;
    // listview
    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        firebaseAuth = FirebaseAuth.getInstance();

        // New added
        fUpdateProfile = FirebaseDatabase.getInstance();

        dbRerence = fUpdateProfile.getReference().child("Profile");




        if (firebaseAuth.getCurrentUser() == null) {
            finish();
            startActivity(new Intent(getApplicationContext(), Login.class));
        }
        FirebaseUser user = firebaseAuth.getCurrentUser();
        part = (Button) findViewById(R.id.participate);
        textUserEmail = (TextView) findViewById(R.id.textViewUserEmail);
        textUserEmail.setText("Welcome   " + user.getEmail());
        buttonLogOut = (Button) findViewById(R.id.buttonLogOut);
        upDateProfile = (Button) findViewById(R.id.buttonUpdateInfor);
        textName = (TextView) findViewById(R.id.editName);
        textSurname = (TextView) findViewById(R.id.editSurname);
        textProvence = (TextView) findViewById(R.id.editProvence);
        textAdress = (TextView) findViewById(R.id.editAdress);
        textCellNo = (TextView) findViewById(R.id.ediCellPhone);
        rdM = (RadioButton) findViewById(R.id.rdMale);
        rdF = (RadioButton) findViewById(R.id.rdFamale);
        rdD = (RadioButton) findViewById(R.id.rdDonar);
        rdR = (RadioButton) findViewById(R.id.rdDtype);
        radioGender =(RadioGroup) findViewById(R.id.genders);
        radioParticipants = (RadioGroup) findViewById(R.id.userType);
        List<ProfileUpdation> ProfileUpdations = new ArrayList<>();
        buttonLogOut.setOnClickListener(this);
        upDateProfile.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view == buttonLogOut)
        {

            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(getApplicationContext(),Login.class));

        }
        if(view == upDateProfile)
        {


            int selectedId= radioGender.getCheckedRadioButtonId();
            rdM =(RadioButton)findViewById(selectedId);
            textCity = (TextView) findViewById(R.id.editCity) ;
            int selectedId2 = radioParticipants.getCheckedRadioButtonId();
            rdD =(RadioButton)findViewById(selectedId2);

            // validating fields
            String name1 = textName.getText().toString();
            String surname1 = textSurname.getText().toString();
            String cities = textCity.getText().toString();
            String provence1  = textProvence.getText().toString();
            String address = textAdress.getText().toString();
            String  cell = textCellNo.getText().toString();
            String radionM = rdM.getText().toString();
            String radioF = rdF.getText().toString();
            String radioD = rdD.getText().toString();
            String radioR = rdR.getText().toString();


            Validation v_object = new Validation();


                if (v_object.Is_Valid_Name(name1)== true)
                {

                    valid = true;

                }
               else if(v_object.Is_Valid_Surname(surname1)== true)
                {
                    valid = true;

                }
                else if(v_object.vili_address(address)== true)
                {
                    valid = true;

                }
                else if(v_object.Valid_Cell(cell)== true)
                {
                    valid = true;

                }

                else if(v_object.vali_Provence(provence1)== true)
                {
                    valid = true;

                }

                else if(v_object.Valid_City(cities)== true)
                {
                    valid = true;

                }

                while (valid==true)
                {

                    ProfileUpdation setting = new ProfileUpdation(name1,surname1,address,cities,provence1,cell,radionM,radioD);


                    dbRerence.setValue(setting);
                    Toast.makeText(this, "Profile updation is complete", Toast.LENGTH_LONG).show();

                }

        }
       else
        {
            Toast.makeText(this, "Profile updation failed", Toast.LENGTH_LONG).show();
        }



    }


    public  void showMenu(View view)
    {
        Intent intent = new Intent(this,Participate.class);
        startActivity(intent);

    }

}
