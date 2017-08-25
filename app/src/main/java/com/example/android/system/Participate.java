package com.example.android.system;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

public class Participate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_participate);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_participate,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.donates:
                donalteShow();
                //this.switchLanguage(language);
                return true;
            case R.id.get:

                ReceiveteShow();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void donalteShow()
    {
        Intent intent = new Intent(this,Donate.class);
        startActivity(intent);

    }

    public void ReceiveteShow()
    {
        //Intent intent = new Intent(this,Receive.class);
        //startActivity(intent);

    }


}
