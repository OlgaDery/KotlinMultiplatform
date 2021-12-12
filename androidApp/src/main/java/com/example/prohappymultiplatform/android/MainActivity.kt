package com.example.prohappymultiplatform.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.prohappymultiplatform.Greeting
import android.widget.TextView
import com.example.prohappymultiplatform.Platform


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv: TextView = findViewById(R.id.text_view)
        tv.text = Platform().date().toString()
    }
}
