package holguin.videoplayerappjacob;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
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

    private VideoView videoView; //initializing display objects
    private TextView title;
    private TextView volumeText;
    private TextView progressText;

    private ToggleButton playBtn; //initializing usable objects
    private SeekBar progressBar;
    private SeekBar volumeBar;

    MediaPlayer mediaPlayer; //"controllers"
    AudioManager audioManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playBtn = (ToggleButton)findViewById(R.id.playButton); //declaring display widgets
        title = (TextView)findViewById(R.id.titleText);
        volumeText = (TextView)findViewById(R.id.textVolume);
        progressText = (TextView)findViewById(R.id.textProgress);

        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.video); //declaring audio and visual elements ... giving video file path
        videoView = (VideoView)findViewById(R.id.videoView);
        videoView.setVideoPath(String.valueOf(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video))); //giving video file path
        progressBar = (SeekBar)findViewById(R.id.progressBar);
        progressBar.setMax(mediaPlayer.getDuration());

        audioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE); //giving the manager
        volumeBar = (SeekBar)findViewById(R.id.volumeBar);
        volumeBar.setProgress(100);
        volumeBar.setMax(audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC));


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
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, i, 0);
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
                if(b)
                {
                    videoView.seekTo(i);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        Thread t = new Thread() {

            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(750);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if(videoView.isPlaying())
                                {
                                    progressBar.setProgress(videoView.getCurrentPosition());
                                }
                                else
                                {
                                    playBtn.setChecked(false);
                                }
                            }
                        });
                    }
                } catch (InterruptedException e) {
                }
            }
        };

        t.start();


    }
}
