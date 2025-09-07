package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SearchView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class gplayerlist : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_gplayerlist)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val list = findViewById<ListView>(R.id.glist)
        val q = mutableListOf<String>()
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, q)
        val search = findViewById<SearchView>(R.id.searchViewg)
        list.adapter = adapter
        adapter.add("Remove")
        adapter.add("СЕЙСЕН Мұхамеджан")
        adapter.add("ЧОНДРИЧ Йосип")
        adapter.add("ЗАРУЦКИЙ Александр")
        adapter.add("АНАРБЕКОВ Темірлан")
        adapter.add("ШАЙЗАДА Бекхан")



        val db = db(this, null)
        search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean = false

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.filter.filter(newText)
                return true
            }
        })

        p.init(this)   //

        list.setOnItemClickListener { parent, view, position, id ->
            fun checkMoney(id : Int, money : Int) : Int{
                val selected = p.selectedPlayerId
                val q = p.restMoney
                val m = db.getPlayerMoney(id).toInt() - money
                if (p.restMoney + m >= 0){
                    p.restMoney += m
                }else{
                    Toast.makeText(this, "You do not have enough money", Toast.LENGTH_SHORT).show()
                }
                return (q + m)

            }

            val name = parent.getItemAtPosition(position).toString()
            val selected = p.selectedPlayerId
            if (name == "СЕЙСЕН Мұхамеджан" && db.isNameFree(R.drawable.seisen)) {
                if (checkMoney(selected, 10000) >= 0) {
                    db.updatePlayerImage(p.selectedPlayerId, R.drawable.seisen, "СЕЙСЕН Мұхамеджан", "10000")
                }
            }
            else if (name == "Remove" && checkMoney(selected, 0) >= 0){
                db.updatePlayerImage(p.selectedPlayerId, R.drawable._348811, "Null", "0")
            }
            else if (name == "ЧОНДРИЧ Йосип" && db.isNameFree(R.drawable.chondrich)) {
                if (checkMoney(selected, 9500) >= 0) {
                    db.updatePlayerImage(p.selectedPlayerId, R.drawable.chondrich, "ЧОНДРИЧ Йосип", "9500")
                }
            }
            else if (name == "ЗАРУЦКИЙ Александр" && db.isNameFree(R.drawable.zaritski)) {
                if (checkMoney(selected, 12000) >= 0) {
                    db.updatePlayerImage(p.selectedPlayerId, R.drawable.zaritski, "ЗАРУЦКИЙ Александр", "12000")
                }
            }
            else if (name == "АНАРБЕКОВ Темірлан" && db.isNameFree(R.drawable.anarbek)) {
                if (checkMoney(selected, 10500) >= 0) {
                    db.updatePlayerImage(p.selectedPlayerId, R.drawable.anarbek, "АНАРБЕКОВ Темірлан", "10500")
                }
            }
            else if (name == "ШАЙЗАДА Бекхан" && db.isNameFree(R.drawable.shaizada)) {
                if (checkMoney(selected, 8500) >= 0) {
                    db.updatePlayerImage(p.selectedPlayerId, R.drawable.shaizada, "ШАЙЗАДА Бекхан", "8500")
                }
            }
            else{
                Toast.makeText(this, "This player is already in your team", Toast.LENGTH_SHORT).show()
            }
            finish()
            startActivity(Intent(this, Transfers::class.java))
        }
    }
    override fun onBackPressed() {
        finish()
        startActivity(Intent(this, Transfers::class.java))

    }
}