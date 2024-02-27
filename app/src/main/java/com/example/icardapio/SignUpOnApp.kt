package com.example.icardapio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SignUpOnApp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_on_app)

        findViewById<Button>(R.id.button_sign_up).setOnClickListener{
            val intent = Intent(this,SignInOnApp :: class.java)
            startActivity(intent)
        }
    }
}