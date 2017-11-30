package holguin.jacobaccelerometerapp;

import android.content.Context;
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
        valueText.setText("Sensor Value Changed");

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
