package com.example.localization

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.localization.databinding.ActivityMainBinding
import java.util.*

// MASIH ADA BUG
class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private var checked = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.switchLanguage.isChecked = checked

    }

    override fun onResume() {
        super.onResume()
        switchChecked()
    }

    private fun switchChecked(){
        binding.switchLanguage.setOnCheckedChangeListener { _, isChecked ->
            checked = !checked
            if(isChecked){
                setJav("ja")
            }else{
                setJav("id")
            }
        }
    }

    private fun setJav(lang : String){
        val myLocale = Locale(lang)
        val conf = resources.configuration
        conf.locale = myLocale
        resources.updateConfiguration(conf,resources.displayMetrics)
        startActivity(Intent(this,MainActivity::class.java))

    }
}