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
    MediaPlayer DBell;
//    double x, y, z;
    float[] linear_acceleration = new float[3];
    float[] gravity = new float[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE); //sets up the sensor Manager
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        DBell = MediaPlayer.create(getApplicationContext(),R.raw.bell);  //sets the bell file path
        title = (TextView)findViewById(R.id.titleText);
        textView = (TextView)findViewById(R.id.textView);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if(sensorEvent.sensor.getType() == Sensor.TYPE_ACCELEROMETER)
        {
            Float alpha = 0.8f;
            gravity[0] = alpha * gravity[0] + (1 - alpha) * sensorEvent.values[0];
            gravity[1] = alpha * gravity[1] + (1 - alpha) * sensorEvent.values[1];
            gravity[2] = alpha * gravity[2] + (1 - alpha) * sensorEvent.values[2];
            linear_acceleration[0] = Math.abs(sensorEvent.values[0] - gravity[0]);
            linear_acceleration[1] = Math.abs(sensorEvent.values[1] - gravity[1]);
            linear_acceleration[2] = Math.abs(sensorEvent.values[2] - gravity[2]);
//            x = Math.abs(sensorEvent.values[0] - gravity[0]);
//            y = Math.abs(sensorEvent.values[1] - gravity[1]);
//            z = Math.abs(sensorEvent.values[0] - gravity[2]);


            if((linear_acceleration[0] > 3) || (linear_acceleration[1] > 3) || (linear_acceleration[2] > 3))
            {
                textView.setTextColor(Color.parseColor("#000000"));
                DBell.start();
            }
            else{
                textView.setTextColor(Color.parseColor("#CCCCCC"));
                DBell.pause();
            }
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
