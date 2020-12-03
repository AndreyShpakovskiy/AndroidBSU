package com.example.menu;

import android.app.Service;
import android.content.Intent;

import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;



public class MyService extends Service {
    private MediaPlayer mPlayer;
    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this, "Service created",Toast.LENGTH_SHORT).show();
        mPlayer = MediaPlayer.create(this, R.raw.song);
        mPlayer.setLooping(false);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "Service started",
                Toast.LENGTH_SHORT).show();
        mPlayer.start();
        return super.onStartCommand(intent, flags, startId);
    }
    @Override
    public void onDestroy() {
        Toast.makeText(this, "Service destroyed", Toast.LENGTH_SHORT).show();
        mPlayer.stop();
    }

}
