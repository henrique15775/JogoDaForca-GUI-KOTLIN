package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class venceu : AppCompatActivity() {
    private lateinit var botao: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_venceu)
        this.botao = findViewById(R.id.botao2)
        this.botao.setOnClickListener{
            val tela_jogo = Intent(this, MainActivity:: class.java)
            startActivity(tela_jogo)
        }
    }
}