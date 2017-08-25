/*package com.example.android.system;

import android.net.http.SslCertificate;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class Receive extends Donate  implements View.OnClickListener {

    private static final String TAG =" " ;
    private TextView dName;
    private Button buttonView;

    private FirebaseDatabase fsendDb,newPho;
    private FirebaseStorage Storage;
    private StorageReference storageRef;
    private DatabaseReference sendRerence,filepath;
    private FirebaseAuth firebaseAuth;
    private ImageButton bntImage;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive);


        dName = (TextView) findViewById(R.id.viewItem);
        buttonView = (Button) findViewById(R.id.view);
        buttonView.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

       // ProfileUpdation setting = new ProfileUpdation();


        if(v ==buttonView)
        {

            ValueEventListener postListener = new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {


                    ProfileUpdation setting  = dataSnapshot.getValue(ProfileUpdation.class);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                }
            };

            //deleting via app
            sendRerence.addValueEventListener(postListener);
        }



    }
}
*/