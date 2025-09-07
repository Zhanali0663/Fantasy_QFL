package com.example.myapplication

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.*
import java.math.BigDecimal

class MyTeam : AppCompatActivity() {
    private lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_my_team)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val p1 = findViewById<ImageView>(R.id.p1m)
        val p2 = findViewById<ImageView>(R.id.p2m)
        val p3 = findViewById<ImageView>(R.id.p3m)
        val p4 = findViewById<ImageView>(R.id.p4m)
        val p5 = findViewById<ImageView>(R.id.p5m)
        val p6 = findViewById<ImageView>(R.id.p6m)
        val p7 = findViewById<ImageView>(R.id.p7m)
        val p8 = findViewById<ImageView>(R.id.p8m)
        val p9 = findViewById<ImageView>(R.id.p9m)
        val p10 = findViewById<ImageView>(R.id.p10m)
        val p11 = findViewById<ImageView>(R.id.p11m)


        val pn0 = findViewById<TextView>(R.id.pn0)
        val pn1 = findViewById<TextView>(R.id.pn1)
        val pn2 = findViewById<TextView>(R.id.pn2)
        val pn3 = findViewById<TextView>(R.id.pn3)
        val pn4 = findViewById<TextView>(R.id.pn4)
        val pn5 = findViewById<TextView>(R.id.pn5)
        val pn6 = findViewById<TextView>(R.id.pn6)
        val pn7 = findViewById<TextView>(R.id.pn7)
        val pn8 = findViewById<TextView>(R.id.pn8)
        val pn9 = findViewById<TextView>(R.id.pn9)
        val pn10 = findViewById<TextView>(R.id.pn10)


        val ps1 = findViewById<TextView>(R.id.ps1)
        val ps2 = findViewById<TextView>(R.id.ps2)
        val ps3 = findViewById<TextView>(R.id.ps3)
        val ps4 = findViewById<TextView>(R.id.ps4)
        val ps5 = findViewById<TextView>(R.id.ps5)
        val ps6 = findViewById<TextView>(R.id.ps6)
        val ps7 = findViewById<TextView>(R.id.ps7)
        val ps8 = findViewById<TextView>(R.id.ps8)
        val ps9 = findViewById<TextView>(R.id.ps9)
        val ps10 = findViewById<TextView>(R.id.ps10)
        val ps11 = findViewById<TextView>(R.id.ps11)

        val totalPts = findViewById<TextView>(R.id.totalPts)
        val overallPts = findViewById<TextView>(R.id.overalpts)
        val gameweek = findViewById<TextView>(R.id.gameweekm)


        val toolbar = findViewById<Toolbar>(R.id.toolbarm)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        toolbar.setNavigationOnClickListener {
            startActivity(Intent(this, MainActivity3::class.java).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK))
        }



        fun setscorecolor(value : Double, ps1 : TextView){
            if (value >= 9.0){
                ps1.setBackgroundColor(Color.parseColor("#122bcc"))

            }
            else if (value >= 8.0){
                ps1.setBackgroundColor(Color.parseColor("#0cf0e8"))
            }

            else if (value >= 7.0){
                ps1.setBackgroundColor(Color.parseColor("#22cc12"))
            }
            else if (value >= 6.0){
                ps1.setBackgroundColor(Color.parseColor("#7d7505"))
            }
            else if (value < 6.0){
                ps1.setBackgroundColor(Color.parseColor("#e81109"))
            }
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


        pn0.text = db.getPlayerName(1)
        pn1.text = db.getPlayerName(2)
        pn2.text = db.getPlayerName(3)
        pn3.text = db.getPlayerName(4)
        pn4.text = db.getPlayerName(5)
        pn5.text = db.getPlayerName(6)
        pn6.text = db.getPlayerName(7)
        pn7.text = db.getPlayerName(8)
        pn8.text = db.getPlayerName(9)
        pn9.text = db.getPlayerName(10)
        pn10.text = db.getPlayerName(11)


        val database = FirebaseDatabase.getInstance()
        val myRef67 = database.getReference("players/gameweek")
        myRef67.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                val value = snapshot.getValue<Int>()
                gameweek.text = value.toString() + "\n Gameweek"

            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@MyTeam, "error", Toast.LENGTH_SHORT).show()
            }

        })



        val myRef69 = database.getReference("players/totalpts")
        myRef69.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                val value = snapshot.getValue<String>()
                overallPts.text = value + "\n Overall Pts"

            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@MyTeam, "error", Toast.LENGTH_SHORT).show()
            }

        })


        //Toast.makeText(this, pn0.text.toString().trim(), Toast.LENGTH_LONG).show()


        val myRef1 = database.getReference("players/" + pn0.text.toString().trim())
        myRef1.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                val value = snapshot.getValue<Double>() ?: 0.0

                ps1.text = value.toString()
                setscorecolor(value, ps1)
                var scores = listOf(ps1.text.toString(), ps2.text.toString(), ps3.text.toString(), ps4.text.toString(), ps5.text.toString(), ps6.text.toString(), ps7.text.toString(), ps8.text.toString(), ps9.text.toString(), ps10.text.toString(), ps11.text.toString())
                var overall = BigDecimal.ZERO
                for (i in 0..scores.size - 1) {
                    overall = overall.add(scores[i].toBigDecimalOrNull() ?: BigDecimal.ZERO)
                }
                totalPts.text = (overall.toPlainString() + "\nTotal Pts")

            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@MyTeam, "error", Toast.LENGTH_SHORT).show()
            }

        })


        val myRef2 = database.getReference("players/" + pn1.text.toString().trim())
        myRef2.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                val value = snapshot.getValue<Double>() ?: 0.0
                ps2.text = value.toString()
                setscorecolor(value, ps2)
                var scores = listOf(ps1.text.toString(), ps2.text.toString(), ps3.text.toString(), ps4.text.toString(), ps5.text.toString(), ps6.text.toString(), ps7.text.toString(), ps8.text.toString(), ps9.text.toString(), ps10.text.toString(), ps11.text.toString())
                var overall = BigDecimal.ZERO
                for (i in 0..scores.size - 1) {
                    overall = overall.add(scores[i].toBigDecimalOrNull() ?: BigDecimal.ZERO)
                }
                totalPts.text = (overall.toPlainString() + "\nTotal Pts")
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@MyTeam, "error", Toast.LENGTH_SHORT).show()
            }

        })

        val myRef3 = database.getReference("players/" + pn2.text.toString().trim())
        myRef3.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                val value = snapshot.getValue<Double>() ?: 0.0
                ps3.text = value.toString()
                setscorecolor(value, ps3)
                var scores = listOf(ps1.text.toString(), ps2.text.toString(), ps3.text.toString(), ps4.text.toString(), ps5.text.toString(), ps6.text.toString(), ps7.text.toString(), ps8.text.toString(), ps9.text.toString(), ps10.text.toString(), ps11.text.toString())
                var overall = BigDecimal.ZERO
                for (i in 0..scores.size - 1) {
                    overall = overall.add(scores[i].toBigDecimalOrNull() ?: BigDecimal.ZERO)
                }
                totalPts.text = (overall.toPlainString() + "\nTotal Pts")
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@MyTeam, "error", Toast.LENGTH_SHORT).show()
            }

        })

        val myRef4 = database.getReference("players/" + pn3.text.toString().trim())
        myRef4.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                val value = snapshot.getValue<Double>() ?: 0.0
                ps4.text = value.toString()
                setscorecolor(value, ps4)
                var scores = listOf(ps1.text.toString(), ps2.text.toString(), ps3.text.toString(), ps4.text.toString(), ps5.text.toString(), ps6.text.toString(), ps7.text.toString(), ps8.text.toString(), ps9.text.toString(), ps10.text.toString(), ps11.text.toString())
                var overall = BigDecimal.ZERO
                for (i in 0..scores.size - 1) {
                    overall = overall.add(scores[i].toBigDecimalOrNull() ?: BigDecimal.ZERO)
                }
                totalPts.text = (overall.toPlainString() + "\nTotal Pts")
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@MyTeam, "error", Toast.LENGTH_SHORT).show()
            }

        })


        val myRef5 = database.getReference("players/" + pn4.text.toString().trim())
        myRef5.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                val value = snapshot.getValue<Double>() ?: 0.0
                ps5.text = value.toString()
                setscorecolor(value, ps5)
                var scores = listOf(ps1.text.toString(), ps2.text.toString(), ps3.text.toString(), ps4.text.toString(), ps5.text.toString(), ps6.text.toString(), ps7.text.toString(), ps8.text.toString(), ps9.text.toString(), ps10.text.toString(), ps11.text.toString())
                var overall = BigDecimal.ZERO
                for (i in 0..scores.size - 1) {
                    overall = overall.add(scores[i].toBigDecimalOrNull() ?: BigDecimal.ZERO)
                }
                totalPts.text = (overall.toPlainString() + "\nTotal Pts")
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@MyTeam, "error", Toast.LENGTH_SHORT).show()
            }

        })



        val myRef6 = database.getReference("players/" + pn5.text.toString().trim())
        myRef6.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                val value = snapshot.getValue<Double>() ?: 0.0
                ps6.text = value.toString()
                setscorecolor(value, ps6)
                var scores = listOf(ps1.text.toString(), ps2.text.toString(), ps3.text.toString(), ps4.text.toString(), ps5.text.toString(), ps6.text.toString(), ps7.text.toString(), ps8.text.toString(), ps9.text.toString(), ps10.text.toString(), ps11.text.toString())
                var overall = BigDecimal.ZERO
                for (i in 0..scores.size - 1) {
                    overall = overall.add(scores[i].toBigDecimalOrNull() ?: BigDecimal.ZERO)
                }
                totalPts.text = (overall.toPlainString() + "\nTotal Pts")
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@MyTeam, "error", Toast.LENGTH_SHORT).show()
            }

        })



        val myRef7 = database.getReference("players/" + pn6.text.toString().trim())
        myRef7.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                val value = snapshot.getValue<Double>() ?: 0.0
                ps7.text = value.toString()
                setscorecolor(value, ps7)
                var scores = listOf(ps1.text.toString(), ps2.text.toString(), ps3.text.toString(), ps4.text.toString(), ps5.text.toString(), ps6.text.toString(), ps7.text.toString(), ps8.text.toString(), ps9.text.toString(), ps10.text.toString(), ps11.text.toString())
                var overall = BigDecimal.ZERO
                for (i in 0..scores.size - 1) {
                    overall = overall.add(scores[i].toBigDecimalOrNull() ?: BigDecimal.ZERO)
                }
                totalPts.text = (overall.toPlainString() + "\nTotal Pts")
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@MyTeam, "error", Toast.LENGTH_SHORT).show()
            }

        })



        val myRef8 = database.getReference("players/" + pn7.text.toString().trim())
        myRef8.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                val value = snapshot.getValue<Double>() ?: 0.0
                ps8.text = value.toString()
                setscorecolor(value, ps8)
                var scores = listOf(ps1.text.toString(), ps2.text.toString(), ps3.text.toString(), ps4.text.toString(), ps5.text.toString(), ps6.text.toString(), ps7.text.toString(), ps8.text.toString(), ps9.text.toString(), ps10.text.toString(), ps11.text.toString())
                var overall = BigDecimal.ZERO
                for (i in 0..scores.size - 1) {
                    overall = overall.add(scores[i].toBigDecimalOrNull() ?: BigDecimal.ZERO)
                }
                totalPts.text = (overall.toPlainString() + "\nTotal Pts")
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@MyTeam, "error", Toast.LENGTH_SHORT).show()
            }

        })



        val myRef9 = database.getReference("players/" + pn8.text.toString().trim())
        myRef9.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                val value = snapshot.getValue<Double>() ?: 0.0
                ps9.text = value.toString()
                setscorecolor(value, ps9)
                var scores = listOf(ps1.text.toString(), ps2.text.toString(), ps3.text.toString(), ps4.text.toString(), ps5.text.toString(), ps6.text.toString(), ps7.text.toString(), ps8.text.toString(), ps9.text.toString(), ps10.text.toString(), ps11.text.toString())
                var overall = BigDecimal.ZERO
                for (i in 0..scores.size - 1) {
                    overall = overall.add(scores[i].toBigDecimalOrNull() ?: BigDecimal.ZERO)
                }
                totalPts.text = (overall.toPlainString() + "\nTotal Pts")
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@MyTeam, "error", Toast.LENGTH_SHORT).show()
            }

        })


        val myRef10 = database.getReference("players/" + pn9.text.toString().trim())
        myRef10.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                val value = snapshot.getValue<Double>() ?: 0.0
                ps10.text = value.toString()
                setscorecolor(value, ps10)
                var scores = listOf(ps1.text.toString(), ps2.text.toString(), ps3.text.toString(), ps4.text.toString(), ps5.text.toString(), ps6.text.toString(), ps7.text.toString(), ps8.text.toString(), ps9.text.toString(), ps10.text.toString(), ps11.text.toString())
                var overall = BigDecimal.ZERO
                for (i in 0..scores.size - 1) {
                    overall = overall.add(scores[i].toBigDecimalOrNull() ?: BigDecimal.ZERO)
                }
                totalPts.text = (overall.toPlainString() + "\nTotal Pts")
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@MyTeam, "error", Toast.LENGTH_SHORT).show()
            }

        })




        val myRef11 = database.getReference("players/" + pn10.text.toString().trim())
        myRef11.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                val value = snapshot.getValue<Double>() ?: 0.0
                ps11.text = value.toString()
                setscorecolor(value, ps11)
                var scores = listOf(ps1.text.toString(), ps2.text.toString(), ps3.text.toString(), ps4.text.toString(), ps5.text.toString(), ps6.text.toString(), ps7.text.toString(), ps8.text.toString(), ps9.text.toString(), ps10.text.toString(), ps11.text.toString())
                var overall = BigDecimal.ZERO
                for (i in 0..scores.size - 1) {
                    overall = overall.add(scores[i].toBigDecimalOrNull() ?: BigDecimal.ZERO)
                }
                totalPts.text = (overall.toPlainString() + "\nTotal Pts")
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@MyTeam, "error", Toast.LENGTH_SHORT).show()
            }

        })





        var scores = listOf(ps1.text.toString(), ps2.text.toString(), ps3.text.toString(), ps4.text.toString(), ps5.text.toString(), ps6.text.toString(), ps7.text.toString(), ps8.text.toString(), ps9.text.toString(), ps10.text.toString(), ps11.text.toString())







    }
}