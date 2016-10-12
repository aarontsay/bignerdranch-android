package com.aarontsay.android.medapp;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TimerAndMusic extends AppCompatActivity {
    private Button mPlay, mPause, mStop;
    private String mTimerText;
    private TextView mTimerTextView;

    private boolean isPaused;
    private boolean isStopped;
    private boolean isPlaying;
    private boolean isStarted;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer_and_music);

        mPlay = (Button) findViewById(R.id.play_button);
        mPause = (Button) findViewById(R.id.pause_button);
        mStop = (Button) findViewById(R.id.stop_button);

        isPaused = false;
        isStopped = false;
        isPlaying = false;
        isStarted = false;

        final MediaPlayer startMeditationChant = MediaPlayer.create(TimerAndMusic.this, R.raw.smg);

        mTimerTextView = (TextView) findViewById(R.id.timer_text_view);
        mTimerTextView.setText("01:00:00");

      // TEST UNITS
      int tenSeconds = 10000;
      int thirtySeconds = 30000;
      int oneMinute = 60000;
      int fiveMinutes = oneMinute * 5;

      final CountDownTimer timer = new CountDownTimer(3600000 * 2, 1000) {
        public void onTick(long millisUntilFinished) {
          // gives warning for locale, but String is strictly numerical
          String hms = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millisUntilFinished),
            TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millisUntilFinished)),
            TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)));
          mTimerTextView.setText(hms);
        }
        public void onFinish() {
                mTimerTextView.setText("Sadhu");
            }
      }.start();

      mPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              // stopped and play is pressed
              if(isStopped) {
                try {
                  startMeditationChant.prepare();
                  // timer.start();
                  // TODO timer
                } catch (IOException e) {
                  e.printStackTrace();
                }
                isStopped = false;
                isPlaying = true;
                isStarted = false;
              }

              // if !isStarted
              if(!isStarted) {
                startMeditationChant.start();
                isStarted = true;
                isPlaying = true;
                // TODO add timer\
              }

                // paused and play is pressed
                if(isPaused) {
                    startMeditationChant.start();
                    timer.resume();
                    }
                isPaused = false;
                isPlaying = true;

                // not playing and play is pressed
                if(!isPlaying && isStarted) {
                    startMeditationChant.start();
                    isPlaying = true;
                    isStopped = false;
                    isPaused = false;

                    // TODO add timer
                }

                // not paused and play is pressed
                /*
                if(!isPaused) {
                    // DO NOTHING
                }
                */
                // not stopped and play is pressed
                /*
                if(!isPaused) {
                    // DO NOTHING
                }
                */
                // playing and play is pressed
                /*
                if(isPlaying) {
                    // DO NOTHING
                }
                */
            }
        });

        mPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // if isPlaying, then pause
                if(isPlaying) {
                    startMeditationChant.pause();
                    isPlaying = false;
                    isPaused = true;
                    // TODO add timer
                }
                // if isPaused
                /*
                if(isPaused) {
                  // DO NOTHING
                }
                */
                // if isStopped
                /*if(isStopped) {
                    // DO NOTHING
                }
                */
            }
        });

        mStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              // if isPlaying, then Stop pressed OR if isPaused, then Stop pressed
              if(isPlaying || isPaused) {
                startMeditationChant.stop();
                isStopped = true;
                isPlaying = false;
                isPaused = false;
                isStarted = false;
                // timer.cancel();
                // TODO add timer

              }

              // if isStopped, then Stop pressed
              /*
              if(isStopped) {
                // DO NOTHING
              }
              */
            }
        });
    }
}
