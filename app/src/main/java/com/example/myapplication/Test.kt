package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.*

class Test : AppCompatActivity() {

    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("message")
        val text = findViewById<TextView>(R.id.testvi)




        myRef.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                val value = snapshot.getValue<String>()
                text.text = value.toString()
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@Test, "error", Toast.LENGTH_SHORT).show()
            }

        })
    }
}