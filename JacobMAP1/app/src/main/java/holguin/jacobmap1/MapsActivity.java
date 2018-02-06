package holguin.jacobmap1;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Marker merk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Adding new markers to the map
        LatLng dreamLocation = new LatLng(64.157224, -20.016390); //creates LatLng coordinate position
        mMap.addMarker(new MarkerOptions()
                .position(dreamLocation) //assigns the marker to the created LatLng
                .title("Dream Vacation Location")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

        LatLng initalLoc1 = new LatLng(66.25, -21.5);
        mMap.addMarker(new MarkerOptions()
                .position(initalLoc1)
                .draggable(true) //makes the marker draggable
                .snippet("Snippet: This is a snippet.") //subtitle thingy
                .title("Draggable location marker") //main title
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)) //changes the color of the marker
                .alpha(0.7f)); //changes the alpha of the marker

        LatLng initalLoc2 = new LatLng(65, -50);
        merk = mMap.addMarker(new MarkerOptions()
                .snippet("This marker will move to 0, 0 once a marker is clicked.")
                .draggable(true)
                .position(initalLoc2)
                .title("Image marker")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.lightbulb))); //turns the marker into an image

        mMap.moveCamera(CameraUpdateFactory.newLatLng(dreamLocation));

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() { //marker onClickListener
            @Override
            public boolean onMarkerClick(Marker marker) { //changes the marker to the origin point.$
                LatLng newPos = new LatLng(0, 0);
                merk.setPosition(newPos);

                return false;
            }
        });
    }
}
