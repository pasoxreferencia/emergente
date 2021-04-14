package com.example.dialogkk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.dialogkk.databinding.ActivityMainBinding

private val TAG= "Mensajes"
private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val boton = binding.addButton
        boton.setOnClickListener {
            val ventana = ventanaemergente()
            ventana.show(supportFragmentManager, "TAG")


        val boton2 = binding.readbutton
        boton2.setOnClickListener {

            db.collection("users")
                .get()
                .addOnSuccessListener { result ->
                    for (document in result) {
                        Log.d(TAG, "${document.id} => ${document.data}")
                    }
                }
                .addOnFailureListener { exception ->
                    Log.w(TAG, "Error getting documents.", exception)
                }

        }
        }
    }
}