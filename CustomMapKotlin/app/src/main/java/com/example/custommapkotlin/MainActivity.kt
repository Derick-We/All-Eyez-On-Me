package com.example.custommapkotlin

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.custommapkotlin.databinding.ActivityMainBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MapStyleOptions

class MainActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var binding: ActivityMainBinding
    private lateinit var map: GoogleMap
    private var currentStyle = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        binding.fabStyle.setOnClickListener {
            changeMapStyle()
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap

        // Configuração inicial do mapa
        val initialLocation = LatLng(-23.550520, -46.633308) // São Paulo
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(initialLocation, 12f))
        
        // Habilita controles do mapa
        map.uiSettings.apply {
            isZoomControlsEnabled = true
            isCompassEnabled = true
            isMapToolbarEnabled = true
        }

        // Aplica o estilo inicial
        applyMapStyle()
    }

    private fun changeMapStyle() {
        currentStyle = (currentStyle + 1) % 3
        applyMapStyle()
    }

    private fun applyMapStyle() {
        val styleResourceId = when (currentStyle) {
            0 -> R.raw.map_style_retro
            1 -> R.raw.map_style_night
            else -> R.raw.map_style_nature
        }

        try {
            val success = map.setMapStyle(
                MapStyleOptions.loadRawResourceStyle(this, styleResourceId)
            )
            if (!success) {
                Toast.makeText(this, "Erro ao carregar estilo do mapa", Toast.LENGTH_SHORT).show()
            }
        } catch (e: Exception) {
            Toast.makeText(this, "Erro ao carregar estilo do mapa", Toast.LENGTH_SHORT).show()
        }
    }
} 