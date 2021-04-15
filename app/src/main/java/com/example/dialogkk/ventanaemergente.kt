package com.example.dialogkk

import android.app.AlertDialog
import android.app.Dialog
import android.content.ContentValues.TAG
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import com.example.dialogkk.databinding.DialogBinding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

// Access a Cloud Firestore instance from your Activity
val db = Firebase.firestore

private lateinit var binding: DialogBinding


class ventanaemergente: DialogFragment() {



    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

       val binding = view?.let { DialogBinding.bind(it) }
      // val edad= binding?.age.toString()
       // val nombre= binding?.username.toString()

        return activity?.let {
            val builder = AlertDialog.Builder(it)
            // Get the layout inflater
            val inflater = requireActivity().layoutInflater
//            val nombre= findViewbyId(<EditText>(R.id.username)
  //          val edad= findViewbyId<EditText>(R.id.age)

            // Inflate and set the layout for the dialog
            // Pass null as the parent view because its going in the dialog layout
            builder.setView(inflater.inflate(R.layout.dialog, null))


                // Add action buttons
                .setPositiveButton("Guardar",
                    DialogInterface.OnClickListener { dialog, id ->
                        val edad= binding?.age.toString()
                        val nombre= binding?.username.toString()

                        // sign in the user ...
                        // Create a new user with a name and age
                        val user = hashMapOf(

                                /*"first" to "Diva",
                                "last" to "Loca",
                                "born" to 1234*/

                           "name" to binding?.username,
                           "age" to binding?.age,

                        )

                        // Add a new document with a generated ID
                        db.collection("pacientes")
                            .add(user)
                            .addOnSuccessListener { documentReference ->
                                Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
                            }
                            .addOnFailureListener { e ->
                                Log.w(TAG, "Error adding document", e)
                            }


                    })
                .setNegativeButton("Volver",
                    DialogInterface.OnClickListener { dialog, id ->
                        getDialog()?.cancel()
                    })
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }




}