package com.aarontsay.android.vipassanametta;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.CountDownTimer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Play_Activity extends AppCompatActivity {
    Button play, pause, stop;

    boolean isStopped;
    boolean isPaused;

    int mDurationSeconds;
    String mTimerText;
    long oldMillis;
    long oldCount;

    private TextView mTextField;

    /*
    CountDownTimer timer = new CountDownTimer(30000, 1000) {
        @Override
        public void onTick(long millisUntilFinished) {

            //mTimerText.format("%02d:%02d:%02d", 30000 / 3600, 30000 % 3600, 30000 % 60);
            mTextField.setText(mTimerText + millisUntilFinished);
        }

        @Override
        public void onFinish() {
            mTextField.setText("done!");
        }
    };
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_);

        play = (Button) findViewById(R.id.button);
        pause = (Button) findViewById(R.id.button2);
        stop = (Button) findViewById(R.id.button3);

        isStopped = false;

        final MediaPlayer sound = MediaPlayer.create(Play_Activity.this, R.raw.smg);

        mTextField = (TextView) findViewById(R.id.timer_text_view);
        mTextField.setText("01:00:00");

        final CounterClass timer = new CounterClass(3600000, 1000);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isStopped) {
                    try {
                        sound.prepare();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    isStopped = false;
                }
                if (isPaused) {
                    sound.start();
                    timer.start();
                    isPaused = false;
                }

                sound.start();
                timer.start();
                // TODO if paused, resume timer
            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sound.isPlaying()) {
                    sound.pause();
                    oldMillis = timer.getMillisAtPause();
                    oldCount = timer.getCountDownInterval();
                    timer.cancel();
                    isPaused = true;
                    // TODO timer wait
                }
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sound.isPlaying()) {
                    timer.cancel();
                    sound.stop();
                    isStopped = true;
                }
            }
        });
    }

    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    @SuppressLint ("NewApi")
    public class CounterClass extends CountDownTimer {

        long countDownInterval;
        long millisAtPause;

        public CounterClass(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);

            this.countDownInterval = countDownInterval;
        }

        @TargetApi(Build.VERSION_CODES.GINGERBREAD)
        @SuppressLint ("NewApi")
        @Override
        public void onTick(long millisUntilFinished) {
            long millis = millisUntilFinished;
            this.millisAtPause = millis;
            String hms = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millis),
                    TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
                    TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
            System.out.println(hms);
            mTextField.setText(hms);
        }

        public long getMillisAtPause() {
            return this.millisAtPause;
        }

        public long getCountDownInterval() {
            return this.countDownInterval;
        }

        public void recreateTimer() {
            
        }

        @Override
        public void onFinish() {
            mTextField.setText("Sadhu. Sadhu. Sadhu.");
        }


    }
}
