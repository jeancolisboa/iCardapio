package com.example.icardapio

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.icardapio.databinding.ActivitySignInOnAppBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

class SignInOnApp : AppCompatActivity() {
    private lateinit var binding: ActivitySignInOnAppBinding

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("http://10.0.2.2/")
        .build()
        .create(SignInOnApp.enviaUsuario::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignInOnAppBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.buttonSignInFood.setOnClickListener {
            val usuario = Usuario()
            usuario.nome = binding.campoName.text.toString()
            usuario.senha = binding.campoPassword.text.toString()

            chamaAPI(usuario)
        }
    }

    private fun chamaAPI(usuario: Usuario) {
        retrofit.setUsuario(usuario.nome, usuario.senha).enqueue(object : Callback<Usuario> {
            override fun onFailure(call: Call<Usuario>, t: Throwable) {
                Log.d("Erro: ", t.toString())
            }

            override fun onResponse(call: Call<Usuario>, response: Response<Usuario>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        if (response.body()!!.nome.equals("vazio")) {
                            exibeToast(false)
                        } else {
                            exibeToast(true)
                        }
                    }
                }
            }
        })
    }

    private fun exibeToast(respostaServidor: Boolean){
        if(respostaServidor){
            Toast.makeText(this,"Usuário autenticado",Toast.LENGTH_LONG).show()
        } else run {
            Toast.makeText(this, "Usuário ou senha incorreta", Toast.LENGTH_LONG).show()
        }
    }

    interface enviaUsuario {
        @FormUrlEncoded
        @POST("autentica.php")
        fun setUsuario (
            @Field("nome") nome: String,
            @Field("senha") senha: String
        ) : Call<Usuario>
    }
}
