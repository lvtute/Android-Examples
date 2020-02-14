package com.example.ex3_hikerswatch;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;
import java.util.Locale;
import java.util.WeakHashMap;

public class MainActivity extends AppCompatActivity {

    LocationManager locationManager;
    LocationListener locationListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                updateLocationInfo(location);
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        };
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED){
            // if permission is not granted
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION},1);
        } else {
            // if we already had the permission
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,0,0,locationListener);
            Location lastKnownLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            if (lastKnownLocation != null){
                updateLocationInfo(lastKnownLocation);

            }
        }
     }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED) {

            startListening();
        }

    }
    public void startListening(){
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED) {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
        }
    }

    public void updateLocationInfo(Location location){

        TextView latTextView = findViewById(R.id.lat_text_view);
        TextView longTextView = findViewById(R.id.long_text_view);
        TextView accTextView = findViewById(R.id.acc_text_view);
        TextView altTextView = findViewById(R.id.alt_text_view);
        TextView addressTextView = findViewById(R.id.address_text_view);

        latTextView.setText("Latitude: "+ location.getLatitude());
        longTextView.setText("Longtitude: "+ location.getLongitude());
        accTextView.setText("Accuracy: "+ location.getAccuracy());
        altTextView.setText("Altitude: "+ location.getAltitude());

        String address = "Could not find address";
        Geocoder geocoder = new Geocoder(this, Locale.getDefault());

        try {
            List<Address> addressList = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
            if (addressList != null && addressList.size()>0){
                address="Address:\n";
                if (addressList.get(0).getThoroughfare()!= null){
                    address += addressList.get(0).getThoroughfare()+'\n';
                }
                if (addressList.get(0).getLocality()!= null){
                    address += addressList.get(0).getLocality()+' ';
                }
                if (addressList.get(0).getPostalCode()!= null){
                    address += addressList.get(0).getPostalCode()+' ';
                }
                if (addressList.get(0).getAdminArea()!= null){
                    address += addressList.get(0).getAdminArea();
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }


        addressTextView.setText(address);
     }
}
