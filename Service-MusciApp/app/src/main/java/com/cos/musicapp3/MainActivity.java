package com.cos.musicapp3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity2";

    private ImageView btnPlayStop;
    private SeekBar seekBar;
    private TextView tvTime;

    private int isPlaying = -1; // 1은 음악재생, -1은 음악멈춤
    private MusicService musicService;
    private MediaPlayer mp;

    Handler handler = new Handler();
    private Thread uiHandleThread;
    private boolean threadStatus = false;

    ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            mp = ((MusicService.LocalBinder) iBinder).getMp();
            seekBarInit();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            mp.stop();
            mp.release();
        }
    };

    public void seekBarInit() {
        seekBar.setMax(mp.getDuration());
        seekBar.setProgress(0);
    }

    public void musicStart() {
        mp.start();
        btnPlayStop.setImageResource(R.drawable.ic_pause);
    }
    public void musicPause() {
        mp.pause();
        btnPlayStop.setImageResource(R.drawable.ic_play);
    }
    public void musicStop() {
        mp.seekTo(0);
        btnPlayStop.setImageResource(R.drawable.ic_play);
        seekBar.setProgress(0);
        threadStatus = true;

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPlayStop = findViewById(R.id.btn_play_stop);
        seekBar = findViewById(R.id.seekBar);
        tvTime = findViewById(R.id.tv_time);

        Intent musicIntent = new Intent(MainActivity.this, MusicService.class);
        bindService(musicIntent, connection, BIND_AUTO_CREATE);

        btnPlayStop.setOnClickListener(view -> {
            isPlaying = isPlaying * -1;
            if(isPlaying == 1) {
                musicStart();
            } else {
                musicPause();
            }
            uiHandleThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (isPlaying == 1) {
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                seekBar.setProgress(mp.getCurrentPosition());
                                if(mp.getCurrentPosition() >= mp.getDuration()) {
                                    musicStop();
                                }
                            }
                        });
                        try {
                            Thread.sleep(1000);
                            if(threadStatus) {
                                uiHandleThread.interrupt();
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            uiHandleThread.start();
        });
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if(b) {
                    mp.seekTo(i);
                }

                int m = i /60000;
                int s = (i % 60000) / 1000;
                String strTime = String.format("%02d:%02d", m ,s);
                tvTime.setText(strTime);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}