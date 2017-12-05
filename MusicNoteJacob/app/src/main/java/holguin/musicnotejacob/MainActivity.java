package holguin.musicnotejacob;

import android.content.Context;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    SensorManager sensorManager;
    Sensor accelerometer;
    TextView title;
    TextView textView;
    MediaPlayer mediaPlayer;
    double x, y, z;
//    Float[] gravity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE); //sets up the sensor Manager
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.bell);  //sets the bell file path
        title = (TextView)findViewById(R.id.titleText);
        textView = (TextView)findViewById(R.id.textView);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if(sensorEvent.sensor.getType() == Sensor.TYPE_ACCELEROMETER){
            Float alpha = 0.8f;
//            gravity[0] = alpha * gravity[0] + (1 - alpha) * sensorEvent.values[0];
//            gravity[1] = alpha * gravity[1] + (1 - alpha) * sensorEvent.values[1];
//            gravity[2] = alpha * gravity[2] + (1 - alpha) * sensorEvent.values[2];
            x = Math.abs(sensorEvent.values[0]);
            y = Math.abs(sensorEvent.values[1]);
            z = Math.abs(sensorEvent.values[0]);


            if((x > 3) || (y - 9.81> 3) || (z > 3)){
                textView.setTextColor(Color.parseColor("#000000"));
                mediaPlayer.start();
            }
            else{
                textView.setTextColor(Color.parseColor("#CCCCCC"));
                mediaPlayer.pause();
            }
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
