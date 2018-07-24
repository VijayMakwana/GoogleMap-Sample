package googlemapsample.com

import android.annotation.SuppressLint
import android.location.Location
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.google.android.gms.location.*
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.PolylineOptions
import com.google.maps.android.PolyUtil
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity(), OnMapReadyCallback {


    private val TAG = MainActivity::class.java.simpleName

    private lateinit var fusedLocationClient: FusedLocationProviderClient

    private var currentLat: Double? = null
    private var currentLng: Double? = null

    private var currentChangedLat: Double? = null
    private var currentChangedLng: Double? = null

    private var destLat: Double? = null
    private var destLng: Double? = null

    private var destination: String = ""

    var sourceMarker: Marker? = null

    private var mGmap: GoogleMap? = null

    private lateinit var locationCallback: LocationCallback

    @SuppressLint("MissingPermission")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

        fusedLocationClient.lastLocation
                .addOnSuccessListener { location: Location? ->
                    // Got last known location. In some rare situations this can be null.
                    currentLat = location?.latitude
                    currentLng = location?.longitude

                    /*sync map with fragment*/
                    (supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment).getMapAsync(this)

                }

        locationCallback = object : LocationCallback() {
            override fun onLocationResult(locationResult: LocationResult?) {
                locationResult ?: return
                for (location in locationResult.locations) {
                    // Update UI with location data
                    currentChangedLat = location?.latitude
                    currentChangedLng = location?.longitude
                    Log.d(TAG, "onLocationChanged: $currentChangedLat,$currentChangedLng")
                }
            }
        }

        fusedLocationClient.requestLocationUpdates(LocationRequest().setInterval(300),
                locationCallback,
                null /* Looper */)

        btnStart.setOnClickListener {
            destination = etDestination?.text.toString()

            val split = destination.split(",")
            destLat = split[0].toDouble()
            destLng = split[1].toDouble()
            val destination = LatLng(destLat!!, destLng!!)
            mGmap?.addMarker(destination.let { MarkerOptions().position(it).title("Marker in Destination") })

            getDirectionData()
        }

    }

    override fun onMapReady(mMap: GoogleMap?) {
        mGmap = mMap

        Log.d(TAG, "onMapReady: $currentLat, $currentLng")
        currentChangedLat = currentLat
        currentChangedLng = currentLng

        val source = currentChangedLat?.let { currentChangedLng?.let { it1 -> LatLng(it, it1) } }

        sourceMarker = mGmap?.addMarker(source?.let { MarkerOptions().position(it).title("Marker in Source") })
        mGmap?.animateCamera(CameraUpdateFactory.newLatLngZoom(source, 12F))

    }

    private fun getDirectionData() {
        ApiClient.createService().getRouteDirectionData(origin = "$currentLat,$currentLng",
                destination = destination,
                key = getString(R.string.google_maps_direction_key)).enqueue(object : Callback<RouteDirectionDataResp?> {
            override fun onFailure(call: Call<RouteDirectionDataResp?>?, t: Throwable?) {
                Log.e(TAG, "onFailure: ", t)

            }

            override fun onResponse(call: Call<RouteDirectionDataResp?>?, response: Response<RouteDirectionDataResp?>?) {
                Log.d(TAG, "onResponse: ${response?.body().toString()}")
                response?.body()?.routes?.forEach {
                    drawDirectionToStop(it.overviewPolyline)
                }
            }
        })
    }

    private fun drawDirectionToStop(overviewPolyline: OverviewPolyline?) {
        if (overviewPolyline != null) {

            val listOfLatLng = PolyUtil.decode(overviewPolyline.points)

            val lineOptions = PolylineOptions()
            lineOptions.addAll(listOfLatLng)
            lineOptions.width(8f)
            lineOptions.color(ContextCompat.getColor(this, android.R.color.holo_blue_dark))
            mGmap?.addPolyline(lineOptions)
        }
    }
}
