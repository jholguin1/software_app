package holguin.jacobaccelerometerapp;

import android.content.Context;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    SensorManager sensorManager;
    Sensor accelerometer;
    TextView title;
    TextView valueText;
    double x, y, z;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);

        title = (TextView)findViewById(R.id.titleText);
        valueText = (TextView)findViewById(R.id.valueText);




    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if(sensorEvent.sensor.getType() == Sensor.TYPE_ACCELEROMETER){
            x = Math.abs(sensorEvent.values[0]);
            y = Math.abs(sensorEvent.values[1]);
            z = Math.abs(sensorEvent.values[0]);
            if((x > 3) || (y - 9.81 > 3) || (z > 3)){
                valueText.setTextColor(Color.parseColor("#000000"));
            }
            else{
                valueText.setTextColor(Color.parseColor("#CCCCCC"));
            }
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
