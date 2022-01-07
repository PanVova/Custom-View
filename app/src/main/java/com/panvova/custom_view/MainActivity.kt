package com.panvova.custom_view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.panvova.custom_view.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.view1.setOnClickListener {
            Toast.makeText(applicationContext, "View 1 clicked", Toast.LENGTH_SHORT).show()
        }

        binding.view2.setOnClickListener {
            Toast.makeText(applicationContext, "View 2 clicked", Toast.LENGTH_SHORT).show()
        }
    }
}