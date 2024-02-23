package com.example.icardapio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.terms_of_use_button).setOnClickListener{
            val dialog = FragmentTermsOfUse()
            dialog.show(supportFragmentManager,dialog.tag)
        }
    }
}