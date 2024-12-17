package com.example.week5task

import SpacingItemDecoration
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.week5task.adapter.hRecyleAdapter
import com.example.week5task.databinding.ActivityDestinationBinding

class DestinationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDestinationBinding
    private lateinit var adapter: hRecyleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDestinationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        enableEdgeToEdge()

        val recyclerView: RecyclerView = binding.hRecycler
        val spacing = resources.getDimensionPixelSize(R.dimen.recycler_view_spacing)
        recyclerView.addItemDecoration(SpacingItemDecoration(spacing))

        val subjectList = arrayOf(
            "Intro to Programming",
            "Linear Algebra",
            "Object Oriented Programming",
            "DSA in Java",
            "Intro to Programming",
            "Object Oriented Programming"
        )

        val dateList = arrayOf(
            "2024-12-17",
            "2024-12-18",
            "2024-12-19",
            "2024-12-20",
            "2024-12-21",
            "2024-12-22"
        )

        val statusList = arrayOf(
            "Present",
            "Absent",
            "Present",
            "Present",
            "Absent",
            "Present"
        )

        val name = intent.getStringExtra("name") ?: "N/A"
        val email = intent.getStringExtra("email") ?: "N/A"
        val country = intent.getStringExtra("country") ?: "N/A"
        val city = intent.getStringExtra("city") ?: "N/A"

        binding.nameVw.text = "Welcome $name"
        binding.emailVw.text = "Email: $email"
        binding.countryVw.text = "Country: $country"
        binding.cityVw.text = "City: $city"

        adapter = hRecyleAdapter(this, subjectList, dateList, statusList)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}
