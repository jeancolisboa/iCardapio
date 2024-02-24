package com.example.icardapio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.terms_of_use_button).setOnClickListener{ //encontra o id do campo correto e faz "ouve" a ação dele
            val dialog = FragmentTermsOfUse() //declara a variavel dialog que recebe o Fragmento que queremos chamar
            dialog.show(supportFragmentManager,dialog.tag) //exibe o dialogo que declaramos
        }

        findViewById<TextView>(R.id.signin).setOnClickListener{ // encontra o id do textview de cadastrar
            val intent = Intent(this,SignInOnApp :: class.java) //chama a activity da tela de cadastrar
            startActivity(intent) // comeca a activity
        }

        findViewById<TextView>(R.id.signup).setOnClickListener{ // encontra o id do textview de entrar
            val intenttwo = Intent(this,SignUpOnApp :: class.java) //chama a activity da tela de entrar
            startActivity(intenttwo) // comeca a activity
        }
    }
}