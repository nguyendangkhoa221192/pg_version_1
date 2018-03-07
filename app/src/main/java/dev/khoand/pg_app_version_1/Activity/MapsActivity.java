package dev.khoand.pg_app_version_1.Activity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import butterknife.BindView;
import butterknife.ButterKnife;
import dev.khoand.pg_app_version_1.Global.GlobalInfo;
import dev.khoand.pg_app_version_1.R;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, View.OnClickListener {

    private GoogleMap mMap;
    private boolean mLocationPermissionGranted = false;
    private static final int PERMISSIONS_REQUEST_ACCESS_LOCATION = 1;
    private Location mLastKnownLocation;
    private LatLng newLocation;
    private GlobalInfo info;

    @BindView(R.id.btnMapCancel) Button btn_cancel;
    @BindView(R.id.btnMapUpdate) Button btn_update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        ButterKnife.bind(this);
        info = (GlobalInfo) getApplicationContext();
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnMapCancel:
                MapsActivity.this.finish();
                break;
            case R.id.btnMapUpdate:
                if (newLocation == null) {
                    Toast.makeText(MapsActivity.this, getString(R.string.checkloction_message_fail_update), Toast.LENGTH_SHORT).show();
                } else {
                    pushCheckLocation();
                }
                break;
        }
    }

    private void pushCheckLocation() {

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

        // Add a marker in Sydney and move the camera
//        LatLng sydney = new LatLng(-34, 151);
//        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        getLocationPermission();
        if (mLocationPermissionGranted) {
            // For dropping a marker at a point on the Map
            double lat = 10.823129;
            double lng = 106.626184;
            if (info.getCurrentBestLocation() != null) {
                lat = info.getCurrentBestLocation().getLatitude();
                lng = info.getCurrentBestLocation().getLongitude();
            }
            String storeTile = "";
            String storeDescription = "";
            if (info.getCurStore() != null && info.getCurStore().getLat() != 0 && info.getCurStore().getLng() != 0) {
                lat = info.getCurStore().getLat();
                lng = info.getCurStore().getLng();
                storeTile = info.getCurStore().getTitle();
                storeDescription = info.getCurStore().getDescription();
            } else {
                newLocation = new LatLng(lat, lng);
            }

            LatLng storeLocation = new LatLng(lat, lng);
            MarkerOptions markerOptions = new MarkerOptions().position(storeLocation).title(storeTile).snippet(storeDescription);
            mMap.addMarker(markerOptions);

            CameraPosition cameraPosition = new CameraPosition.Builder().target(storeLocation).zoom(12).build();
            mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

            final String finalStoreTile = storeTile;
            final String finalStoreDescription = storeDescription;

            mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
                @Override
                public void onMapClick(LatLng latLng) {
                    mMap.clear();
                    MarkerOptions markerOptions = new MarkerOptions().position(latLng).title(finalStoreTile).snippet(finalStoreDescription);
                    mMap.addMarker(markerOptions);
                    newLocation = latLng;
                }
            });
        }
    }

    private void getLocationPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
                && ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            mLocationPermissionGranted = true;
        } else {
            ActivityCompat.requestPermissions(this,
                    new String[]{
                            android.Manifest.permission.ACCESS_FINE_LOCATION,
                            android.Manifest.permission.ACCESS_COARSE_LOCATION
                    }, PERMISSIONS_REQUEST_ACCESS_LOCATION
            );
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        mLocationPermissionGranted = false;
        switch (requestCode) {
            case PERMISSIONS_REQUEST_ACCESS_LOCATION: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED
                        && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                    mLocationPermissionGranted = true;
                }
            }
        }
        updateLocationUI();
    }

    private void updateLocationUI() {
        if (mMap == null) {
            return;
        }
        try {
            if (mLocationPermissionGranted) {
                mMap.setMyLocationEnabled(true);
                mMap.getUiSettings().setMyLocationButtonEnabled(true);
            } else {
                mMap.setMyLocationEnabled(false);
                mMap.getUiSettings().setMyLocationButtonEnabled(false);
                mLastKnownLocation = null;
                getLocationPermission();
            }
        } catch (SecurityException e)  {
            Log.e("Exception: %s", e.getMessage());
        }
    }
}
