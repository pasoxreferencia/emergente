package com.example.dialogkk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

private val TAG= "DocSnippets"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val boton = findViewById<Button>(R.id.addButton)
        boton.setOnClickListener {
            val ventana = ventanaemergente()
            ventana.show(supportFragmentManager, "TAG")


        val boton2 = findViewById<Button>(R.id.readbutton)
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