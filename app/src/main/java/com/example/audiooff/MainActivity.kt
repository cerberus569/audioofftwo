package com.example.audiooff

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.Manifest
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.media.AudioManager
import android.speech.RecognitionListener
import android.speech.SpeechRecognizer
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var audioManager: AudioManager
    private lateinit var speechRecognizer: SpeechRecognizer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        audioManager = getSystemService(Context.AUDIO_SERVICE) as AudioManager
        speechRecognizer = SpeechRecognizer.createSpeechRecognizer(this)

        val recognitionListener = object : RecognitionListener {
            // Implement speech recognition callbacks here.
        }

        speechRecognizer.setRecognitionListener(recognitionListener)

        val button
        button.setOnClickListener {
            // Guardar el nombre en la caja de texto.
        }

        val callReceiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                // Detectar llamadas entrantes y comparar con el nombre guardado.
                // Mostrar el mensaje si coincide.
            }
        }

        val intentFilter = IntentFilter()
        intentFilter.addAction("android.intent.action.PHONE_STATE")
        registerReceiver(callReceiver, intentFilter)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        // Manejar la respuesta de permisos aquí.
    }

    override fun onDestroy() {
        super.onDestroy()
        // Liberar recursos y detener el reconocimiento de voz.
    }
}

