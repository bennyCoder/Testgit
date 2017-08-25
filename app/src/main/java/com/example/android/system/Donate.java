package com.example.android.system;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.net.URI;

import static android.R.attr.contextUri;
import static android.R.attr.data;
import static com.example.android.system.R.layout.activity_donate;

public class Donate extends AppCompatActivity implements View.OnClickListener{
    private FirebaseDatabase fsendDb,newPho;
    private FirebaseStorage Storage;
    private StorageReference storageRef;
    private DatabaseReference sendRerence,filepath;
    private FirebaseAuth firebaseAuth;
    private ImageButton bntImage;

    private Button btnSend;
    private EditText itemNameS;
    private int image;
private  static final int GALLERY_INTENT =2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_donate);


        firebaseAuth = FirebaseAuth.getInstance();

        // New added
       fsendDb = FirebaseDatabase.getInstance();
        Storage = FirebaseStorage.getInstance();


        sendRerence = fsendDb.getReference().child("Items");

        //storageRef = Storage.getReference().child("Items");


        if (firebaseAuth.getCurrentUser() == null) {
            finish();
            startActivity(new Intent(getApplicationContext(), Donate.class));
        }
        bntImage = (ImageButton)findViewById(R.id.Upload);
        itemNameS = (EditText) findViewById(R.id.itemName);
        btnSend = (Button) findViewById(R.id.send);
        btnSend.setOnClickListener(this);

        bntImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               // Intent intents = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
               //File f = new File(android.os.Environment.getExternalStorageDirectory(), "rose.jpg");
               // intents.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(f));
              // startActivityForResult(intents, 1);



                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent,GALLERY_INTENT);


            }
        });

    }

//public void populate(View view)
//{

  //  Intent intent = new Intent(this,Donate.class);
   // startActivity(intent);


//}


    @Override
    public void onClick(View view) {


        if (view == btnSend) {


            String itemsNames = itemNameS.getText().toString();

//        FirebaseUser user = firebaseAuth.getCurrentUser();


            Items ItemObject = new Items(itemsNames);
          sendRerence.setValue(ItemObject);


        }
}

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

                    // if(requestCode == GALLERY_INTENT && requestCode == RESULT_OK)
                    //{
                        Uri uri = data.getData();
                     //  newPho = FirebaseDatabase.getInstance();

                       //  DatabaseReference filepath = sendRerence.child("Photo").child(uri.getLastPathSegment());

                        // filepath =  newPho.getReference().child("Photo").child(uri.getLastPathSegment());
        storageRef = Storage.getReference().child("PHOTO").child(uri.getLastPathSegment());
                      //  filepath =  newPho.getReference().child("Photo");
                         //filepath.setValue(uri.getLastPathSegment());
                     //}
                    storageRef.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            Toast.makeText(Donate.this,"Items sent successfully",Toast.LENGTH_SHORT).show();
                        }
                    });
    }
}
