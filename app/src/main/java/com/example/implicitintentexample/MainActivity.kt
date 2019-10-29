package com.example.implicitintentexample

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val launchUrl = findViewById<Button>(R.id.launch_url)
        launchUrl.setOnClickListener {
            val intent = Intent().apply {
                action = Intent.ACTION_VIEW
                data = Uri.parse("https://www.google.com")
            }

            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            } else{
                Toast.makeText(this, "No activity found to handle this intent",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }
}
