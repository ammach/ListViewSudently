package com.example.ammach.listviewsudently;

import android.app.Application;

import com.parse.Parse;

/**
 * Created by ammach on 2/20/2016.
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(this, "GPv2Z8RfsjEiOVaWoKaLgSUEbhq2rdUjEX3Kj2UT", "vMKfHKboiqcaunGvAKKpZwnAAlIt2q8kcyGmr6YE");
    }
}
