package com.example.rodrigo_s13

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MainActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var map: GoogleMap
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private lateinit var searchView: SearchView

    private val LOCATION_PERMISSION_REQUEST = 100
    private var listaTiendas: List<Tienda> = emptyList()
    private var tiendasFiltradas: List<Tienda> = emptyList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.mapFragment) as SupportMapFragment
        mapFragment.getMapAsync(this)

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        searchView = findViewById(R.id.searchView)

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                mostrarTiendaMasCercana()
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filtrarTiendas(newText ?: "")
                return true
            }
        })
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
        enableMyLocation()
        listaTiendas = TiendaDataProvider.getTiendas()
        mostrarTiendas(listaTiendas)
    }

    private fun enableMyLocation() {
        if (ActivityCompat.checkSelfPermission(
                this, Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED &&
            ActivityCompat.checkSelfPermission(
                this, Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                LOCATION_PERMISSION_REQUEST
            )
            return
        }

        map.isMyLocationEnabled = true

        fusedLocationClient.lastLocation.addOnSuccessListener { location ->
            location?.let {
                val currentLatLng = LatLng(it.latitude, it.longitude)
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(currentLatLng, 15f))
                map.addMarker(
                    MarkerOptions()
                        .position(currentLatLng)
                        .title("Estás aquí")
                )

                val tiendaCercana = obtenerTiendaMasCercana(it.latitude, it.longitude, listaTiendas)
                tiendaCercana?.let { (tienda, distancia) ->
                    val mensaje = "Tienda más cercana: ${tienda.nombre} a ${distancia.toInt()} metros"
                    Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == LOCATION_PERMISSION_REQUEST &&
            grantResults.isNotEmpty() &&
            grantResults[0] == PackageManager.PERMISSION_GRANTED
        ) {
            enableMyLocation()
        }
    }

    private fun filtrarTiendas(texto: String) {
        tiendasFiltradas = listaTiendas.filter {
            it.descripcion.contains(texto, ignoreCase = true) ||
                    it.nombre.contains(texto, ignoreCase = true)
        }

        mostrarTiendas(tiendasFiltradas)
    }

    private fun mostrarTiendaMasCercana() {
        fusedLocationClient.lastLocation.addOnSuccessListener { location ->
            location?.let {
                val tiendaCercana = obtenerTiendaMasCercana(it.latitude, it.longitude, tiendasFiltradas)
                tiendaCercana?.let { (tienda, distancia) ->
                    val mensaje = "Tienda más cercana: ${tienda.nombre} a ${distancia.toInt()} metros"
                    Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun mostrarTiendas(tiendas: List<Tienda>) {
        map.clear()

        for (tienda in tiendas) {
            map.addMarker(
                MarkerOptions()
                    .position(tienda.latLng)
                    .title(tienda.nombre)
                    .snippet(tienda.descripcion)
            )
        }

        val chimbote = LatLng(-9.0730, -78.5900)
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(chimbote, 13f))
    }

    private fun obtenerTiendaMasCercana(
        lat: Double,
        lon: Double,
        tiendas: List<Tienda>
    ): Pair<Tienda, Float>? {
        if (tiendas.isEmpty()) return null

        var tiendaCercana: Tienda? = null
        var distanciaMinima = Float.MAX_VALUE

        for (tienda in tiendas) {
            val resultado = FloatArray(1)
            android.location.Location.distanceBetween(
                lat, lon,
                tienda.latitud, tienda.longitud,
                resultado
            )
            if (resultado[0] < distanciaMinima) {
                distanciaMinima = resultado[0]
                tiendaCercana = tienda
            }
        }

        return tiendaCercana?.let { Pair(it, distanciaMinima) }
    }
}
