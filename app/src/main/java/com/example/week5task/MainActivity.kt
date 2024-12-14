package com.example.week5task

import android.content.Intent
import android.graphics.pdf.content.PdfPageGotoLinkContent.Destination
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.RadioButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.week5task.databinding.ActivityMainBinding

class MainActivity :View.OnClickListener, AppCompatActivity(), AdapterView.OnItemSelectedListener {

     lateinit var binding: ActivityMainBinding
     val countries = arrayOf("Nepal", "China", "India", "Bhutan")
     val city = arrayOf("Bharatpur","Dhaka","Mumbai", "Hong kong")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupSpinner()
        setupAutoComplete()
        setupTrmsAndCndtnsAction()

        setupInsets()
    }

    private fun setupSpinner() {

        val countryAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, countries)
        countryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.countryspnr.adapter = countryAdapter
        binding.countryspnr.onItemSelectedListener = this
    }
    private fun setupTrmsAndCndtnsAction(){

        binding.submitBtn.isEnabled = false
        binding.checkBox.setOnCheckedChangeListener { _, isChecked ->
            binding.submitBtn.isEnabled = isChecked
            binding.submitBtn.setOnClickListener(this)


    }
    }
    private fun setupAutoComplete(){
        val cityAtoCmpltAdapter = ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line,city)
        binding.cityAtocmplt.setAdapter(cityAtoCmpltAdapter)
        binding.cityAtocmplt.threshold = 1
    }

    private fun setupInsets() {

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        // Handle item selection
        val selectedCountry = countries[position]
        Toast.makeText(this, "Selected: $selectedCountry", Toast.LENGTH_SHORT).show()
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        // Handle case where no item is selected
        Toast.makeText(this, "No country selected", Toast.LENGTH_SHORT).show()
    }

    override fun onClick(p0: View?) {
        when(p0){
            binding.submitBtn -> {
               val intent = Intent(this, DestinationActivity::class.java)
                val name : String = binding.nameField.text.toString()
                val email : String = binding.emailField.text.toString()
                val password : String = binding.passwordField.text.toString()
                val selectedGenderId = binding.radioGroup.checkedRadioButtonId
                val selectedRadioButton = findViewById<RadioButton>(selectedGenderId)
                val gender: String = selectedRadioButton.text.toString()
                val country : String = binding.countryspnr.selectedItem.toString()
                val city : String = binding.cityAtocmplt.text.toString()

                intent.putExtra("name", name)
                intent.putExtra("email", email)
                intent.putExtra("password", password)
                intent.putExtra("gender", gender)
                intent.putExtra("country", country)
                intent.putExtra("city", city)

                startActivity(intent)

            }
        }
    }
}
