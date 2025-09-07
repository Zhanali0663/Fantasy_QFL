package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.getValue
import java.math.BigDecimal

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main3)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val exit = findViewById<Button>(R.id.exit)
        val myTeam = findViewById<Button>(R.id.myteam)
        val settings = findViewById<Button>(R.id.settings)
        val transfers = findViewById<Button>(R.id.transfers)







        val database = FirebaseDatabase.getInstance()
        transfers.setOnClickListener {
            val myRef = database.getReference("players/deadlinetbool")
            myRef.addValueEventListener(object : ValueEventListener {

                override fun onDataChange(snapshot: DataSnapshot) {
                    val value = snapshot.getValue<String>()
                    if (value == "1"){


                        startActivity(Intent(this@MainActivity3, deadlinetransfers::class.java))
                    }else{
                        startActivity(Intent(this@MainActivity3, Transfers::class.java))
                    }


                }

                override fun onCancelled(error: DatabaseError) {
                    Toast.makeText(this@MainActivity3, "error", Toast.LENGTH_SHORT).show()
                }

            })


        }
        myTeam.setOnClickListener {
            val myRef = database.getReference("players/deadlinetbool")
            myRef.addValueEventListener(object : ValueEventListener {

                override fun onDataChange(snapshot: DataSnapshot) {
                    val value = snapshot.getValue<String>()
                    if (value == "0"){

                        startActivity(Intent(this@MainActivity3, myteamdeadline::class.java))
                    }else{
                        startActivity(Intent(this@MainActivity3, MyTeam::class.java))
                    }


                }

                override fun onCancelled(error: DatabaseError) {
                    Toast.makeText(this@MainActivity3, "error", Toast.LENGTH_SHORT).show()
                }

            })
        }
        settings.setOnClickListener {
            startActivity(Intent(this, deadlinetransfers::class.java))
        }
        exit.setOnClickListener{startActivity(Intent(this, MenuActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK))}
    }
}