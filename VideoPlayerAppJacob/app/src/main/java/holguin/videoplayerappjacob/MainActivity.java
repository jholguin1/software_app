package holguin.videoplayerappjacob;

import android.support.v7.app.AppCompatActivity;<<<<<<< HEAD
import android.media.AudioManager;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.MediaController;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ToggleButton;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    VideoView videoView;
    TextView title;
    TextView volumeText;
    TextView progressText;
    ToggleButton playBtn;
    SeekBar progressBar;
    SeekBar volumeBar;

=======
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

>>>>>>> parent of 0f2e6d3... Made the videoplayer work
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
<<<<<<< HEAD

        playBtn = (ToggleButton)findViewById(R.id.playButton);
        title = (TextView)findViewById(R.id.titleText);
        volumeText = (TextView)findViewById(R.id.textVolume);
        progressText = (TextView)findViewById(R.id.textProgress);

        videoView = (VideoView)findViewById(R.id.videoView);
        videoView.setVideoPath(String.valueOf(Uri.parse("android.resource://" + getPackageName() +
                "/" + R.raw.video)));


        progressBar = (SeekBar)findViewById(R.id.progressBar);
        progressBar.setMax(videoView.getDuration());

        volumeBar = (SeekBar)findViewById(R.id.volumeBar);
        volumeBar.setProgress(100);
        final AudioManager myAudioManager = (AudioManager) this.getSystemService(getApplicationContext().AUDIO_SERVICE);


        playBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(b)
                {
                    videoView.start();
                }
                else
                {
                    videoView.pause();
                }
            }
        });

        volumeBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                myAudioManager.setStreamVolume(AudioManager.STREAM_MUSIC, i, 1);

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

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


=======
>>>>>>> parent of 0f2e6d3... Made the videoplayer work
    }
}
