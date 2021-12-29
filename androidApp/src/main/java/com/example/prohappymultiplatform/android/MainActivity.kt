package com.example.prohappymultiplatform.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.prohappymultiplatform.Greeting
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.prohappymultiplatform.Platform


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        homeViewModel.initRepo(this)
    }
}
