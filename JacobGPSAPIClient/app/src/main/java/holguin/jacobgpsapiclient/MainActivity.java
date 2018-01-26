package holguin.jacobgpsapiclient;

import android.Manifest;
import android.app.IntentService;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Geocoder;
import android.location.Location;
import android.os.Handler;
import android.os.ResultReceiver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

public class MainActivity extends AppCompatActivity {

    private FusedLocationProviderClient mFusedLocationClient;
    protected Location mLastLocation;
    private AddressResultReceiver mResultReceiver;
    private String mAddressOutput = "";
    private Button button;
    private TextView mLocationAddressTextView;
    private TextView mLocationCoordinates;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this); //assigning values to our objects
        mResultReceiver = new AddressResultReceiver(new Handler());
        button = (Button) findViewById(R.id.button);
        mLocationAddressTextView = (TextView) findViewById(R.id.textView);
        mLocationCoordinates = (TextView)findViewById(R.id.textView1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fetchAddressButtonHandler(view);

            }
        });

    }


    protected void startIntentService() {
        Intent intent = new Intent(this, FetchAddressIntentService.class); //creates and sends intent with extra constants
        intent.putExtra(Constants.RECEIVER, mResultReceiver);
        intent.putExtra(Constants.LOCATION_DATA_EXTRA, mLastLocation);
        startService(intent);
    }


    class AddressResultReceiver extends ResultReceiver {
        public AddressResultReceiver(Handler handler) {
            super(handler);

        }

        @Override
        protected void onReceiveResult(int resultCode, Bundle resultData) { //what to do when we receive results

            // Display the address string
            // or an error message sent from the intent service.
            mAddressOutput = resultData.getString(Constants.RESULT_DATA_KEY);
            mLocationAddressTextView.setText(mAddressOutput); //EXAM - Set textview to latitude & longitude | Set it into the map

            // Show a toast message if an address was found.
            if (resultCode == Constants.SUCCESS_RESULT) {
                //showToast("address_found");
            }

        }
    }


    @SuppressWarnings("MissingPermission") //to view with tablets
    private void fetchAddressButtonHandler(View view) { //what to do when we hit the button

       /* if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED //permission check
                && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }*/

        mFusedLocationClient.getLastLocation() //getting location data
                .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        mLastLocation = location;

                        // In some rare cases the location returned can be null
                        if (mLastLocation == null) {
                            return;
                        }

                        if (!Geocoder.isPresent()) { //checks for geocoder
                            Toast.makeText(MainActivity.this,
                                    "no_geocoder_available",
                                    Toast.LENGTH_LONG).show();
                            return;
                        }

                        // Start service and update UI to reflect new location
                        startIntentService(); //
                        //updateUI();

                    }
                });


    }

    @Override
    public void onStart() {

        super.onStart();

    }
}


