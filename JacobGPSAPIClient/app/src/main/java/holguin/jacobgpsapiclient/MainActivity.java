package holguin.jacobgpsapiclient;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.location.FusedLocationProviderClient; //import statements
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.tasks.OnSuccessListener;

public class MainActivity extends AppCompatActivity {

    private FusedLocationProviderClient fusedLocationClient; //makes a Fused Location Provider Client manages the location and gives the best location according to our needs.

    @Override
    protected void onCreate(Bundle savedInstanceState) { //Google Play Services is a proprietary background service and API package for Android devices
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this); //sets this activity's FusedLocationProviderClient



        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED ) { //checks to see if the permission is granted

            fusedLocationClient.getLastLocation() //using the getLastLocation Method
                    .addOnSuccessListener(this, new OnSuccessListener<Location>() { //program the OnSuccessListener after the permission check and on the getLastLocation.
                        @Override                                                   // the OnSuccessListener listens for the success to come out
                        public void onSuccess(Location location) { //results of the successes
                            // Got last known location. In some rare situations this can be null.
                            if (location != null) {
                                // Logic to handle location object
                            }
                        }
                    });

            return;
        }
    }
}
