package holguin.jacobmusicapp;

import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements Runnable{

    ToggleButton playBtn;
    MediaPlayer mediaPlayer;
    Handler progressHandler = new Handler();
    SeekBar volumeBar;
    SeekBar progressBar;
    TextView title;
    TextView volumeText;
    TextView progressText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //declaring all the widgets and mediaPlayer
        title = (TextView)findViewById(R.id.textView);
        volumeText = (TextView)findViewById(R.id.volumeText);
        progressText = (TextView)findViewById(R.id.progressText);
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.numb); //mediaPlayer plays the file numb
        volumeBar = (SeekBar)findViewById(R.id.volumeBar);
        progressBar = (SeekBar) findViewById(R.id.progressBar);
        playBtn = (ToggleButton)findViewById(R.id.toggleButton);
        volumeBar.setProgress(100); //volumeBar is at 100 by default
        progressBar.setMax(mediaPlayer.getDuration()); //sets the progressBar maximum to the duration of the song.

        playBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    mediaPlayer.start(); //when turned on it plays
                }
                else {
                    mediaPlayer.pause(); //when turned off it doesn't continue

                }
            }
        });

        volumeBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                float volume = (float) i/100;     //translate the data into float to use in mediaPlayer.setVolume
                mediaPlayer.setVolume(volume, volume);      //changes the volume in the left and right ears
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        progressBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                mediaPlayer.seekTo(i, MediaPlayer.SEEK_CLOSEST_SYNC);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    @Override
    public void run() {
        progressBar.setProgress(mediaPlayer.getCurrentPosition());
        progressHandler.postDelayed(run, 1000);

    }
}
