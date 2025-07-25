package com.example.rodrigo_s13

import com.google.android.gms.maps.model.LatLng

data class Tienda(
    val nombre: String,
    val descripcion: String,
    val latitud: Double,
    val longitud: Double
) {
    val latLng: LatLng
        get() = LatLng(latitud, longitud)
}
