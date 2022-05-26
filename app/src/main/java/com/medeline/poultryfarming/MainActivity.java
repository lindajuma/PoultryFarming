package com.medeline.poultryfarming;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.location.Location;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.SettingsClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.util.Map;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {


    public SupportMapFragment mapFragment;
    public GoogleMap map;
    public Button showpoultry;
    public Button sharelocation;
    public FusedLocationProviderClient fusedLocationProviderClient;
    public Location currentLocation;
    public Location userLastKnownLocation;
    public static final int REQUEST_CODE = 101;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        showpoultry = findViewById(R.id.btn_showpoultry_id);
        sharelocation=findViewById(R.id.btn_sharelocation_id);
        showpoultry.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View view) {
                showpoultry();
            }
        });
        sharelocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharelocation();




            }
        });


    }

    ;


    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        map = googleMap;

        map.getUiSettings().setMyLocationButtonEnabled(true);


        //ask for permission
        Dexter.withContext(this)
                .withPermission(Manifest.permission.ACCESS_FINE_LOCATION)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                        LocationRequest locationRequest = LocationRequest.create();
                        locationRequest.setInterval(5000);
                        locationRequest.setFastestInterval(1000);
                        locationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);


                        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder().addLocationRequest(locationRequest);
                        SettingsClient settingsClient = LocationServices.getSettingsClient(MainActivity.this);
                        Task<LocationSettingsResponse> task = settingsClient.checkLocationSettings(builder.build());

                        task.addOnSuccessListener(new OnSuccessListener<LocationSettingsResponse>() {
                            @Override
                            public void onSuccess(LocationSettingsResponse locationSettingsResponse) {

                                showlocation();


                            }


                        });
                    }


                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {
                        Toast.makeText(MainActivity.this, "permission denied", Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                        permissionToken.continuePermissionRequest();

                    }
                }).check();


    }

    @SuppressLint("MissingPermission")
    public void showlocation() {
        map.setMyLocationEnabled(true);
        fusedLocationProviderClient.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
            @Override
            public void onComplete(@NonNull Task<Location> task) {

                if (task.isSuccessful()) {
                    userLastKnownLocation = task.getResult();
                }

                if (userLastKnownLocation != null) {
                    LatLng currentuserLocation = new LatLng(userLastKnownLocation.getLatitude(), userLastKnownLocation.getLongitude());
                    map.moveCamera(CameraUpdateFactory.newLatLngZoom(currentuserLocation, 20));

                } else {


                }
            }

        });


    }

    public void showpoultry() {
        MarkerOptions poultry = new MarkerOptions();
        poultry.position(new LatLng(-0.1038612283608044834, 34.758159843182455));
        poultry.title("poultry");
        map.addMarker(poultry);
        map.animateCamera(CameraUpdateFactory.newLatLng(poultry.getPosition()));
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(poultry.getPosition(), 20));




        MarkerOptions poultry1 = new MarkerOptions();
        poultry1.position(new LatLng(-0.04110612438496129, 34.792633494313456));
        poultry1.title("poultry");
        map.addMarker(poultry);
        map.animateCamera(CameraUpdateFactory.newLatLng(poultry1.getPosition()));
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(poultry1.getPosition(), 25));



        MarkerOptions poultry2 = new MarkerOptions();
        poultry2.position(new LatLng(-0.09529345504435767, 34.76641187405589));
        poultry2.title("poultry");
        map.addMarker(poultry);
        map.animateCamera(CameraUpdateFactory.newLatLng(poultry2.getPosition()));
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(poultry2.getPosition(), 30));



        MarkerOptions poultry3=new MarkerOptions();
        poultry3.position(new LatLng(-0.0888201496874732, 34.76694286510049 ));
        poultry3.title("poultry");
        map.addMarker(poultry);
        map.animateCamera(CameraUpdateFactory.newLatLng(poultry3.getPosition()));
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(poultry3.getPosition(),35));
    }

    public void sharelocation(){
        

    }




    //Receiving the result of the request to turn on GPS


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode== 101){
            if (requestCode==RESULT_OK);
        }
        //user accepted allocation
        showlocation();





    }





};
































































































































