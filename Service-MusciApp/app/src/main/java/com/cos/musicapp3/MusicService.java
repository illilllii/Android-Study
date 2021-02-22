package com.cos.musicapp3;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;

public class MusicService extends Service {
    private static final String TAG = "MusicService";
    private MediaPlayer mp;
    private IBinder mBinder = new LocalBinder();
    public MusicService() {
    }

    class LocalBinder extends  Binder {
        MediaPlayer getMp() {
            return mp;
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mp = MediaPlayer.create(this, R.raw.sample1);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return  mBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}