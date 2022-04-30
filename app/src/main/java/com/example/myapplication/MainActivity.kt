package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import model.JogodaForca
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var palavra: TextView
    private lateinit var dica: TextView



    private lateinit var bancoPalavras: List<String>
    private lateinit var bancoDicas: List<String>
    private lateinit var advising: EditText
    private lateinit var boat : Button
    private lateinit var status: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.bancoPalavras = arrayListOf<String>("Abelha","Urso","Professor")
        this.bancoDicas = arrayListOf<String>("Inseto","Animal Mamifero", "Profissão")

        val randomIndex = Random.nextInt(bancoPalavras.size)

        val randomPalavra = bancoPalavras[randomIndex]
        val randomDica = bancoDicas[randomIndex]
        var new_JogoDaForca = JogodaForca(randomPalavra,randomDica)

        this.palavra = findViewById(R.id.palavra)
        this.dica = findViewById(R.id.dica)
        this.advising = findViewById(R.id.advinha)
        this.boat = findViewById(R.id.botao)
        this.palavra.text = new_JogoDaForca.letrasDescobertas()
        this.dica.text = "Dica: " + new_JogoDaForca.dica
        this.boat.setOnClickListener{
            val jogada = new_JogoDaForca.RodarJogo(this.palavra,this.advising)
            if(jogada == 1){
                    val tela_vitoria = Intent(this, venceu:: class.java)
                    startActivity(tela_vitoria)
                }else if(jogada == -1){
                    val tela_derrota = Intent(this, perdeu:: class.java)
                    startActivity(tela_derrota)
                }
            }
        }

    }