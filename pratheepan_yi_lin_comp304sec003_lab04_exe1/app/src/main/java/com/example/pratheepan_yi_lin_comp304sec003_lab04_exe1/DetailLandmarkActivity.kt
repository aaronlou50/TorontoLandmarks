package com.example.pratheepan_yi_lin_comp304sec003_lab04_exe1

import android.location.Geocoder
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.pratheepan_yi_lin_comp304sec003_lab04_exe1.Database.LandmarkEntity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import java.io.IOException


class DetailLandmarkActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var map: GoogleMap
    private lateinit var landmark: LandmarkEntity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_landmark)

        landmark = intent.getParcelableExtra("EXTRA_LANDMARK") ?: return


        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap

        val address = landmark.address // Ensure your Landmark class has an 'address' property
        val geocoder = Geocoder(this)
        try {
            val addressList = geocoder.getFromLocationName(address, 1)
            if (addressList != null && addressList.isNotEmpty()) {
                val location = addressList[0]
                val landmarkLatLng = LatLng(location.latitude, location.longitude)
                map.addMarker(MarkerOptions().position(landmarkLatLng).title(landmark.name))
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(landmarkLatLng, 15f))
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}

