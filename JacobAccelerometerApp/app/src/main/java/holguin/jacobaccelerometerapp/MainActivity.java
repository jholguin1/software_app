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
    Sensor gyroscope;
    TextView title;
    TextView valueText;
    double x, y, z;
//    Float[] gravity = [0, 0 , 0];
//    Float[] linear_acceleration;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE); //sets up the sensor Manager
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        gyroscope = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        //sensorManager.registerListener(this, gyroscope, SensorManager.SENSOR_DELAY_NORMAL);

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

//        if(sensorEvent.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
//
//            float alpha = 0.8f;
//S
//            if(sensorEvent.values[0] || sensorEvent.values[]) {
//
//
//            }
//            gravity[0] = alpha * gravity[0] + (1 - alpha) * sensorEvent.values[0];
//            gravity[1] = alpha * gravity[1] + (1 - alpha) * sensorEvent.values[1];
//            gravity[2] = alpha * gravity[2] + (1 - alpha) * sensorEvent.values[2];
//
//            // Remove the gravity contribution with the high-pass filter.
//            linear_acceleration[0] = sensorEvent.values[0] - gravity[0];
//            linear_acceleration[1] = sensorEvent.values[1] - gravity[1];
//            linear_acceleration[2] = sensorEvent.values[2] - gravity[2];
//
//
//        }



    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
