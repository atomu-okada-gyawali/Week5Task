package com.example.week5task

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.week5task.databinding.ActivityDestinationBinding

class DestinationActivity : AppCompatActivity() {

    lateinit var binding: ActivityDestinationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDestinationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Enable edge-to-edge mode for a more immersive experience (optional)
        enableEdgeToEdge()

        // Get data from intent
        val name = intent.getStringExtra("name") ?: "N/A"
        val email = intent.getStringExtra("email") ?: "N/A"
        val country = intent.getStringExtra("country") ?: "N/A"
        val city = intent.getStringExtra("city") ?: "N/A"

        // Set text for views using data binding
        binding.nameVw.text = "Welcome $name"
        binding.emailVw.text = "Email: $email"
        binding.countryVw.text = "Country: $country"
        binding.cityVw.text = "City: $city"
    }
}