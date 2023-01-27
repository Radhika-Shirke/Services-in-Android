package com.example.serviceexample;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;
import android.util.Log;

import androidx.annotation.Nullable;

import java.security.Provider;

public class MusicService extends Service {

    MediaPlayer mp;
    private static final String TAG = "MusicService";
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    //Executes in background line by line
    public int onStartCommand(Intent intent, int flags, int startId) {


        //Setting default music
        mp = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI);


        Log.d(TAG, "onStartCommand:  mp is initialized");

        //Playing the ringtone in loops
        mp.setLooping(true);

        //To Play the ringtone
        mp.start();

        return START_NOT_STICKY;
    }

    //Stop the service if System gets destroyed
    @Override
    public void onDestroy() {
        if(mp!=null) {
            mp.stop();
        }
        super.onDestroy();
    }
}
