package holguin.jacobgpsapiclient;

import android.Manifest;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.FusedLocationProviderClient; //import statements
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.SettingsClient;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

public class MainActivity extends AppCompatActivity {

    private FusedLocationProviderClient mFusedLocationClient; //makes a Fused Location Provider Client manages the location and gives the best location according to our needs.
    private LocationCallback mLocationCallback;
    LocationSettingsRequest mLocationSettingRequest;
<<<<<<< HEAD
    protected Location mLastLocation;
    private AddressResultReceiver mResultReceiver;
=======
    LocationRequest mLocationRequest;
>>>>>>> b1caeb556ae48c58410a23f07612e198dd4a0e3a
    boolean mRequestingLocationUpdates = false;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) { //Google Play Services is a proprietary background service and API package for Android devices
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this); //sets this activity's FusedLocationProviderClient
        textView = (TextView) findViewById(R.id.textView);
        textView.setText("Latitude: \nLongitude: "); //default text

        createLocationRequest();

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) { //checks to see if the permission is granted

            ActivityCompat.requestPermissions(this, new String[]{ //if not granted then request permissions
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION}, 33);
            return;
        }

        mFusedLocationClient.getLastLocation() //using the getLastLocation Method
                .addOnSuccessListener(this, new OnSuccessListener<Location>() { //program the OnSuccessListener after the permission check and on the getLastLocation.
                    @Override
                    // the OnSuccessListener listens for the success to come out
                    public void onSuccess(Location location) { //results of the successes
                        // Got last known location. In some rare situations this can be null.

                        if (location != null) {
                            // Logic to handle location object
                            textView.setText("Latitude: " + location.getLatitude() + "\nLongitude: " + location.getLongitude());

                        }
                    }
                });

<<<<<<< HEAD
        mLocationCallback = new LocationCallback() {
            @Override
            public void onLocationResult(LocationRequest locationResult) {
                for (Location location : locationResult.getLocations()) {
                    // Update UI with location data
                    // ...
                }
            }
=======
        mLocationCallback = new LocationCallback() { //creating callback
//            @Override
//            public void onLocationResult(LocationRequest locationResult) {
//                for (Location location : locationResult.getLocations()) {
//                    // Update UI with location data
//                    // ...
//                }
//            }
>>>>>>> b1caeb556ae48c58410a23f07612e198dd4a0e3a
        };

    }

    private void startLocationUpdates() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            return;
        }
        mFusedLocationClient.requestLocationUpdates(mLocationRequest,
                mLocationCallback,
                null /* Looper */);
    }

    @Override
    protected void onResume() { // so that the GPS doesn't continue when in pause and again restarts when resuming the app 1
        super.onResume();
        if (mRequestingLocationUpdates) {
            startLocationUpdates();
        }
    }

    @Override
    protected void onPause() { //2
        super.onPause();
        stopLocationUpdates();
    }

    private void stopLocationUpdates() {
        mFusedLocationClient.removeLocationUpdates(mLocationCallback);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putBoolean("REQUESTING_LOCATION_UPDATES_KEY",
                mRequestingLocationUpdates);
        // ...
        super.onSaveInstanceState(outState);
    }

    private void updateValuesFromBundle(Bundle savedInstanceState) {
        // Update the value of mRequestingLocationUpdates from the Bundle.
        if (savedInstanceState.keySet().contains("REQUESTING_LOCATION_UPDATES_KEY")) {
            mRequestingLocationUpdates = savedInstanceState.getBoolean(
                    "REQUESTING_LOCATION_UPDATES_KEY");
        }

        // ...

        // Update UI to match restored state
        updateUI();
    }

    protected void createLocationRequest() {
        LocationRequest mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(10000);
        mLocationRequest.setFastestInterval(5000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);

        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder()
                .addLocationRequest(mLocationRequest);

        SettingsClient client = LocationServices.getSettingsClient(this);
        Task<LocationSettingsResponse> task = client.checkLocationSettings(builder.build());

        task.addOnSuccessListener(this, new OnSuccessListener<LocationSettingsResponse>() {
            @Override
            public void onSuccess(LocationSettingsResponse locationSettingsResponse) {
                // All location settings are satisfied. The client can initialize
                // location requests here.
                // ...
            }
        });

        task.addOnFailureListener(this, new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                if (e instanceof ResolvableApiException) {
                    // Location settings are not satisfied, but this can be fixed
                    // by showing the user a dialog.
                    try {
                        // Show the dialog by calling startResolutionForResult(),
                        // and check the result in onActivityResult().
                        ResolvableApiException resolvable = (ResolvableApiException) e;
                        resolvable.startResolutionForResult(MainActivity.this,
                                0x1);
                    } catch (IntentSender.SendIntentException sendEx) {
                        // Ignore the error.
                    }
                }
            }
        });


        protected void startIntentService() {
            Intent intent = new Intent(this, FetchAddressIntentService.class);
            intent.putExtra(Constants.RECEIVER, mResultReceiver);
            intent.putExtra(Constants.LOCATION_DATA_EXTRA, mLastLocation);
            startService(intent);
        }

    }

}

