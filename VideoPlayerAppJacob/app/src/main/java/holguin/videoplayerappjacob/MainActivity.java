package holguin.videoplayerappjacob;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ToggleButton;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    VideoView videoView;
    TextView title;
    ToggleButton playBtn;
    SeekBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playBtn = (ToggleButton)findViewById(R.id.playButton);
        videoView = (VideoView)findViewById(R.id.videoView);
        title = (TextView)findViewById(R.id.titleText);
        progressBar = (SeekBar)findViewById(R.id.seekBar);

        playBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                videoView.setVideoPath(String.valueOf(Uri.parse("android.resource://" + getPackageName() +
"/" + R.raw.video)));

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
    }
}
