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
                // isPaused, !isPlaying, isStopped, so a fresh state
                if(!isPaused && !isStopped && !isPlaying) {
                    startMeditationChant.start();
                    isStarted = true;
                }

                // paused and play is pressed
                if(isPaused) {
                    startMeditationChant.start();
                    timer.resume();
                    }
                isPaused = false;

                // stopped and play is pressed
                if(isStopped) {
                    try {
                        startMeditationChant.prepare();
                        timer.start();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                isStopped = false;
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
                // not playing and play is pressed
                if(!isPlaying && isStarted) {
                    startMeditationChant.start();
                }
                // playing and play is pressed
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
