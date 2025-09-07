package com.example.myapplication

import android.content.Intent
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.*
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Transfers : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_transfers)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        p.init(this)   //
        val money = findViewById<TextView>(R.id.money)

        val p1 = findViewById<ImageView>(R.id.p1)
        val p2 = findViewById<ImageView>(R.id.p2)
        val p3 = findViewById<ImageView>(R.id.p3)
        val p4 = findViewById<ImageView>(R.id.p4)
        val p5 = findViewById<ImageView>(R.id.p5)
        val p6 = findViewById<ImageView>(R.id.p6)
        val p7 = findViewById<ImageView>(R.id.p7)
        val p8 = findViewById<ImageView>(R.id.p8)
        val p9 = findViewById<ImageView>(R.id.p9)
        val p10 = findViewById<ImageView>(R.id.p10)
        val p11 = findViewById<ImageView>(R.id.p11)


        val pnt0 = findViewById<TextView>(R.id.pnt0)
        val pnt1 = findViewById<TextView>(R.id.pnt1)
        val pnt2 = findViewById<TextView>(R.id.pnt2)
        val pnt3 = findViewById<TextView>(R.id.pnt3)
        val pnt4 = findViewById<TextView>(R.id.pnt4)
        val pnt5 = findViewById<TextView>(R.id.pnt5)
        val pnt6 = findViewById<TextView>(R.id.pnt6)
        val pnt7 = findViewById<TextView>(R.id.pnt7)
        val pnt8 = findViewById<TextView>(R.id.pnt8)
        val pnt9 = findViewById<TextView>(R.id.pnt9)
        val pnt10 = findViewById<TextView>(R.id.pnt10)


        val m1 = findViewById<TextView>(R.id.m)
        val m2 = findViewById<TextView>(R.id.m2)
        val m3 = findViewById<TextView>(R.id.m3)
        val m4 = findViewById<TextView>(R.id.m4)
        val m5 = findViewById<TextView>(R.id.m5)
        val m6 = findViewById<TextView>(R.id.m6)
        val m7 = findViewById<TextView>(R.id.m7)
        val m8 = findViewById<TextView>(R.id.m8)
        val m9 = findViewById<TextView>(R.id.m9)
        val m10 = findViewById<TextView>(R.id.m10)
        val m11 = findViewById<TextView>(R.id.m11)


        val toolbar = findViewById<Toolbar>(R.id.toolbart)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        toolbar.setNavigationOnClickListener {
            startActivity(Intent(this, MainActivity3::class.java).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK))
        }




        val db = db(this, null)
        p1.setImageResource(db.getPlayerImage(1))
        p2.setImageResource(db.getPlayerImage(2))
        p3.setImageResource(db.getPlayerImage(3))
        p4.setImageResource(db.getPlayerImage(4))
        p5.setImageResource(db.getPlayerImage(5))
        p6.setImageResource(db.getPlayerImage(6))
        p7.setImageResource(db.getPlayerImage(7))
        p8.setImageResource(db.getPlayerImage(8))
        p9.setImageResource(db.getPlayerImage(9))
        p10.setImageResource(db.getPlayerImage(10))
        p11.setImageResource(db.getPlayerImage(11))


        pnt0.text = db.getPlayerName(1)
        pnt1.text = db.getPlayerName(2)
        pnt2.text = db.getPlayerName(3)
        pnt3.text = db.getPlayerName(4)
        pnt4.text = db.getPlayerName(5)
        pnt5.text = db.getPlayerName(6)
        pnt6.text = db.getPlayerName(7)
        pnt7.text = db.getPlayerName(8)
        pnt8.text = db.getPlayerName(9)
        pnt9.text = db.getPlayerName(10)
        pnt10.text = db.getPlayerName(11)


        m1.text = db.getPlayerMoney(1)
        m2.text = db.getPlayerMoney(2)
        m3.text = db.getPlayerMoney(3)
        m4.text = db.getPlayerMoney(4)
        m5.text = db.getPlayerMoney(5)
        m6.text = db.getPlayerMoney(6)
        m7.text = db.getPlayerMoney(7)
        m8.text = db.getPlayerMoney(8)
        m9.text = db.getPlayerMoney(9)
        m10.text = db.getPlayerMoney(10)
        m11.text = db.getPlayerMoney(11)


        money.text = (p.restMoney.toString() + "\n Money")


        p1.setOnClickListener {
            startActivity(Intent(this, Splayerlist::class.java))
            p.selectedPlayerId = 1
            finish()
        }
        p2.setOnClickListener { startActivity(Intent(this, Splayerlist::class.java))
            p.selectedPlayerId = 2
        finish()}
        p3.setOnClickListener { startActivity(Intent(this, Splayerlist::class.java))
            p.selectedPlayerId = 3
        finish()}
        p4.setOnClickListener { startActivity(Intent(this, Mplayerlist::class.java))
            p.selectedPlayerId = 4
            finish()}
        p5.setOnClickListener { startActivity(Intent(this, Mplayerlist::class.java))
            p.selectedPlayerId = 5
            finish()}
        p6.setOnClickListener { startActivity(Intent(this, Mplayerlist::class.java))
            p.selectedPlayerId = 6
            finish()}
        p7.setOnClickListener { startActivity(Intent(this, dplayerlist::class.java))
            p.selectedPlayerId = 7
            finish()}
        p8.setOnClickListener { startActivity(Intent(this, dplayerlist::class.java))
            p.selectedPlayerId = 8
            finish()}
        p9.setOnClickListener { startActivity(Intent(this, dplayerlist::class.java))
            p.selectedPlayerId = 9
            finish()}
        p10.setOnClickListener { startActivity(Intent(this, dplayerlist::class.java))
            p.selectedPlayerId = 10
            finish()}

        p11.setOnClickListener { startActivity(Intent(this, gplayerlist::class.java))
            p.selectedPlayerId = 11
            finish()}



        val gameweek = findViewById<TextView>(R.id.gameweekt)

        val database = FirebaseDatabase.getInstance()
        val myRef637 = database.getReference("players/gameweek")

        myRef637.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                val value = snapshot.getValue<Int>()
                gameweek.text = value.toString() + "\n Gameweek"

            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@Transfers, "error", Toast.LENGTH_SHORT).show()
            }

        })
    }


}