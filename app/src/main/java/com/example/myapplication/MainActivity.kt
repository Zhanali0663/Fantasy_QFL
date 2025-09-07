package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar

import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val text = findViewById<TextView>(R.id.text)
        val name = findViewById<EditText>(R.id.linput)
        val gmail = findViewById<EditText>(R.id.input2)
        val password = findViewById<EditText>(R.id.input3)
        val button = findViewById<Button>(R.id.button)
        val toolbar = findViewById<Toolbar>(R.id.toolbarm)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        toolbar.setNavigationOnClickListener {
            startActivity(Intent(this, MenuActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK))
        }

        val perehodlog = findViewById<TextView>(R.id.registolog)
        perehodlog.setOnClickListener {
            startActivity(Intent(this, MainActivity2::class.java).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK))
        }



        button.setOnClickListener {
            val tName = name.text.toString().trim()
            val tGmail = gmail.text.toString().trim()
            val tPassword = password.text.toString().trim()
            if (tName == "" || tGmail == "" || tPassword == "")
                Toast.makeText(this, "Not all fields are filled in", Toast.LENGTH_LONG).show()
            else{
                val user = register(tName, tGmail, tPassword)
                val db = db(this, null)
                db.addUser(user)
                Toast.makeText(this, "$tName have successfully registered", Toast.LENGTH_LONG).show()
                name.text.clear()
                gmail.text.clear()
                password.text.clear()
                startActivity(Intent(this, MenuActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK))



            }
        }

    }
}