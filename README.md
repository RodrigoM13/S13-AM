<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Rodrigo_S13 - Mapa de Tiendas Tecnológicas</title>
</head>
<body>

<h1>🗺️ Rodrigo_S13 - Mapa de Tiendas Tecnológicas</h1>

<p>Una aplicación Android desarrollada en Kotlin que muestra tiendas de tecnología y periféricos en Google Maps, permitiendo al usuario visualizar la ubicación de cada tienda y realizar búsquedas por tipo de producto (laptops, PC, mouse, audífonos, etc.).</p>

<hr>

<h2>📱 Características</h2>
<ul>
  <li>📍 Muestra la ubicación de varias tiendas tecnológicas en un mapa interactivo.</li>
  <li>🔎 Permite buscar tiendas por nombre o por productos disponibles.</li>
  <li>🧭 Ubicación actual del usuario con marcador y cámara centrada.</li>
  <li>📌 Muestra la tienda más cercana automáticamente al iniciar.</li>
  <li>📋 Información adicional de cada tienda (productos, descripción).</li>
</ul>

<hr>

<h2>🧱 Estructura del Proyecto</h2>
<pre><code>
📂 Rodrigo_S13
├── 📁 app
│   ├── 📁 src
│   │   ├── 📁 main
│   │   │   ├── 📄 MainActivity.kt
│   │   │   ├── 📄 Tienda.kt
│   │   │   ├── 📄 TiendaDataProvider.kt
│   │   │   ├── 📄 res/layout/activity_main.xml
│   │   │   └── 📄 AndroidManifest.xml
├── 📁 screenshots
│   ├── Permisos.png
│   ├── Ubicacion.png
│   ├── Ejemplo_laptop.png
│   ├── Ejemplo_monitor.png
│   ├── Ejemplo_pc.png
│   └── Ejemplo_usb.png
└── 📄 README.md
</code></pre>

<hr>

<h2>🛠️ Tecnologías Utilizadas</h2>
<ul>
  <li><strong>Lenguaje:</strong> Kotlin</li>
  <li><strong>Mapa:</strong> Google Maps SDK</li>
  <li><strong>API de localización:</strong> FusedLocationProviderClient</li>
  <li><strong>Interfaz:</strong> XML con <code>SearchView</code> y <code>SupportMapFragment</code></li>
  <li><strong>Permisos:</strong> ACCESS_FINE_LOCATION y ACCESS_COARSE_LOCATION</li>
</ul>

<hr>

<h2>🚀 Cómo Ejecutar</h2>
<ol>
  <li>Clona el repositorio:
    <pre><code>git clone https://github.com/RodrigoM13/S13-AM.git</code></pre>
  </li>
  <li>Abre el proyecto en <strong>Android Studio</strong>.</li>
  <li>Agrega tu clave de API de Google Maps en <code>AndroidManifest.xml</code>:
    <pre><code>&lt;meta-data
    android:name="com.google.android.geo.API_KEY"
    android:value="TU_API_KEY_AQUI"/&gt;</code></pre>
  </li>
  <li>Ejecuta el proyecto en un emulador o dispositivo físico.</li>
</ol>

<hr>

<h2>🗂️ Datos de las Tiendas</h2>
<p>Se encuentran en <code>TiendaDataProvider.kt</code> con sus respectivas coordenadas y descripciones (productos que venden).</p>

<hr>

<h2>🔍 Ejemplos de Búsqueda</h2>
<ul>
  <li>Escribe <code>laptop</code> o <code>usb</code> para mostrar solo tiendas que ofrezcan ese producto.</li>
  <li>Busca <code>Coolbox</code> para ver su ubicación y descripción.</li>
</ul>

<hr>

<h2>📸 Capturas de Pantalla</h2>

<h3>🔐 Permisos de Ubicación</h3>
<img src="screenshots/Permisos.png" alt="Permisos" width="300"/>

<h3>📍 Ubicación y Tienda más cercana</h3>
<img src="screenshots/Ubicacion.png" alt="Ubicación" width="300"/>

<h3>💻 Búsqueda: Laptop</h3>
<img src="screenshots/Ejemplo_laptop.png" alt="Ejemplo Laptop" width="300"/>

<h3>🖥️ Búsqueda: Monitor</h3>
<img src="screenshots/Ejemplo_monitor.png" alt="Ejemplo Monitor" width="300"/>

<h3>🖱️ Búsqueda: PC</h3>
<img src="screenshots/Ejemplo_pc.png" alt="Ejemplo PC" width="300"/>

<h3>🔌 Búsqueda: USB</h3>
<img src="screenshots/Ejemplo_usb.png" alt="Ejemplo USB" width="300"/>

<hr>

<h2>📄 Licencia</h2>
<p>Este proyecto es de uso académico y personal. Puedes modificarlo y usarlo libremente con fines educativos.</p>

<hr>

<h2>👨‍💻 Autor</h2>
<p><strong>Rodrigo M.</strong><br>
Repositorio: <a href="https://github.com/RodrigoM13/S13-AM" target="_blank">S13-AM</a></p>

</body>
</html>
