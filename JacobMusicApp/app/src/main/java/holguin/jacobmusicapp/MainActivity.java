package holguin.jacobmusicapp;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    ToggleButton playBtn;
    MediaPlayer mediaPlayer;
    SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.numb); //mediaPlayer plays the file numb
        seekBar = (SeekBar)findViewById(R.id.seekBar);
        playBtn = (ToggleButton)findViewById(R.id.toggleButton);
        seekBar.setProgress(100); //seekBar is at 100 by default

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

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                mediaPlayer.seekTo(i, MediaPlayer.SEEK_CLOSEST);
//                float progress = (float) i/100;     //translate the data into float to use in mediaPlayer.setVolume
//                mediaPlayer.setVolume(progress, progress);      //changes the volume in the left and right ears
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
