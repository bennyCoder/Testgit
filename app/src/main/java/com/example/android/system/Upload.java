package com.example.android.system;

/**
 * Created by RP on 2017/08/24.
 */

import com.google.firebase.database.IgnoreExtraProperties;
public class Upload {


    public String name;
    public String url;

    // Default constructor required for calls to
    // DataSnapshot.getValue(User.class)
    public Upload() {
    }

    public Upload(String name, String url) {
        this.name = name;
        this.url= url;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }
}
