package com.aarontsay.android.medapp;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

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

        final CountDownTimer timer = new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                //mTimerTextView.setText(millisUntilFinished / 1000);
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

 /*
 * Example of showing a 30 second countdown in a text field:
 *
 * <pre class="prettyprint">
 * new CountdownTimer(30000, 1000) {
 *
 *     public void onTick(long millisUntilFinished) {
 *         mTextField.setText("seconds remaining: " + millisUntilFinished / 1000);
 *     }
 *
 *     public void onFinish() {
 *         mTextField.setText("done!");
 *     }
 *  }.start();
 * </pre>
 *
 * The calls to {@link #onTick(long)} are synchronized to this object so that
 * one call to {@link #onTick(long)} won't ever occur before the previous
 * callback is complete.  This is only relevant when the implementation of
 * {@link #onTick(long)} takes an amount of time to execute that is significant
 * compared to the countdown interval.
 */

    }
}
