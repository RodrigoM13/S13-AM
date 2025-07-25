package com.example.rodrigo_s13

import com.example.rodrigo_s13.Tienda
import com.google.android.gms.maps.model.LatLng


object TiendaDataProvider {
    fun getTiendas(): List<Tienda> = listOf(
        Tienda("Centro Comercial Cybertech", "Laptops, PC, periféricos, USB", -9.0728547, -78.593326),
        Tienda("Coolbox", "Audífonos, USB, gadgets, mouse", -9.0732262, -78.591996),
        Tienda("Compusally", "PC, monitores, teclado, mouse", -9.0754498, -78.591966),
        Tienda("Coolbox Megaplaza", "Audífonos, periféricos, teclado", -9.1020821, -78.557876),
        Tienda("GlobalTech", "Laptops, impresoras, memorias USB", -9.1280932, -78.517943),
        Tienda("Microtech Service", "Reparación de laptops, USB, monitores", -9.1293715, -78.513452),
        Tienda("Razor Technology", "Componentes de PC, teclado, mouse, audífonos", -9.1283823, -78.498005),
        Tienda("Tech Perú", "PC, laptops, mouse, teclados", -9.0727551, -78.592994)
    )
}

