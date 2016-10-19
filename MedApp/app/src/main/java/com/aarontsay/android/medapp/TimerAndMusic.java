package com.aarontsay.android.medapp;

import android.media.MediaPlayer;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TimerAndMusic extends AppCompatActivity {

  private boolean isPaused;
  private boolean isStopped;
  private boolean isPlaying;
  private boolean isStarted;

  EditText userTimerTextInput;
  EditText userTimerTextHourInput;
  EditText userTimerTextMinuteInput;
  EditText userTimerTextSecondInput;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    ActionBar aBar = getSupportActionBar();
    aBar.hide();

    Button mPlay, mPause, mStop;

    String userTimerTextHourString;
    final String userTimerTextMinuteString;
    final String userTimerTextSecondString;

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_timer_and_music);

    // TODO placeholder image, consider getting rid of in class since we do not manipulate it
    //ImageView wheel = (ImageView) findViewById(R.id.bdc);

    mPlay = (Button) findViewById(R.id.play_button);
    mPause = (Button) findViewById(R.id.pause_button);
    mStop = (Button) findViewById(R.id.stop_button);

    isPaused = false;
    isStopped = false;
    isPlaying = false;
    isStarted = false;

    final MediaPlayer startMeditationChant = MediaPlayer.create(TimerAndMusic.this, R.raw.smg);
    final MediaPlayer endMeditationChant = MediaPlayer.create(TimerAndMusic.this, R.raw.sjoi);

    long startMeditationChantDuration = startMeditationChant.getDuration();
    long endMeditationChantDuration = endMeditationChant.getDuration();

    // eventually set this to user input in configuration/settings page
    // userTimerTextInput = (EditText) findViewById(R.id.user_timer_input);
//    userTimerTextInput.setText("01:00:00");
    // TODO input like scanf("%2d:%2d:%2d", &hh, &mm, &ss)
/*
    userTimerTextHourInput = (EditText) findViewById(R.id.user_timer_hour_input);
    userTimerTextMinuteInput = (EditText) findViewById(R.id.user_timer_minute_input);
    userTimerTextSecondInput = (EditText) findViewById(R.id.user_timer_second_input);

    userTimerTextHourString = userTimerTextHourInput.toString();
    userTimerTextMinuteString = userTimerTextMinuteInput.toString();
    userTimerTextSecondString = userTimerTextSecondInput.toString();
*/
    // TEST UNITS FOR TIMER AND MEDIA PLAYING
    int oneSecond = 1000;
    int tenSeconds = 10000;
    int thirtySeconds = 30000;
    int oneMinute = 60000;
    int fiveMinutes = oneMinute * 5;
    long defaultMeditationDuration = oneMinute * 60;
/*
    long userTimeInput = (Long.parseLong(userTimerTextHourString) * oneMinute * 60) +
      (Long.parseLong(userTimerTextMinuteString) * oneMinute) +
      (Long.parseLong(userTimerTextSecondString) * oneSecond);
*/
    long countDownTimerInput;
    /*
    if(userTimeInput > 0) {
      countDownTimerInput = userTimeInput;
    } else {
      countDownTimerInput = defaultMeditationDuration;
    }*/

    countDownTimerInput = defaultMeditationDuration;

    final CountDownTimer timer = new CountDownTimer(countDownTimerInput, 1000) {
      public void onTick(long millisUntilFinished) {
        /*if(millisUntilFinished == endMeditationChantDuration) {
          startMeditationChant.stop();
          endMeditationChant.start();
          // TODO endMeditationChant to start playing upon respective duration
        }
        */

        /*
        // gives warning for locale, but String is strictly numerical
        String hms = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millisUntilFinished),
          TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millisUntilFinished)),
          TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)));
        userTimerTextInput.setText(hms);
        */

        String hh = String.format("%02d", TimeUnit.MILLISECONDS.toHours(millisUntilFinished));
        String mm = String.format("%02d", TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millisUntilFinished)));
        String ss = String.format("%02d", TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)));

        userTimerTextHourInput.setText(hh);
        userTimerTextMinuteInput.setText(mm);
        userTimerTextSecondInput.setText(ss);
        //userTimerTextHourInput.setText(hh);
      }

      public void onFinish() {
        // userTimerTextInput.setText("Sadhu, Sadhu, Sadhu");
      }
    };

    mPlay.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        // stopped and play is pressed
        if(isStopped) {
          try {
            startMeditationChant.prepare();
            timer.start();
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
          timer.start();
          isStarted = true;
          isPlaying = true;
          userTimerTextInput.setEnabled(false);
        }

        // paused and play is pressed
        if(isPaused) {
          startMeditationChant.start();
          timer.resume();
        }
        isPaused = false;
        isPlaying = true;

              /*
              // not playing and play is pressed
                if(!isPlaying && isStarted) {
                    startMeditationChant.start();

                    isPlaying = true;
                    isStopped = false;
                    isPaused = false;

                    // TODO add timer
                }
              */
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
          timer.pause();
          isPlaying = false;
          isPaused = true;
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
          timer.cancel();
          // userTimerTextInput.selectAll();
          // userTimerTextInput.setEnabled(true);

          isStopped = true;
          isPlaying = false;
          isPaused = false;
          isStarted = false;
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
