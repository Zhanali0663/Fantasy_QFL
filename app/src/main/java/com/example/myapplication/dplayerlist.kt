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

class dplayerlist : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dplayerlist)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        p.init(this)   //
        val list = findViewById<ListView>(R.id.dlist)
        val q = mutableListOf<String>()
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, q)
        val search = findViewById<SearchView>(R.id.searchViewd)
        list.adapter = adapter
        adapter.add("Remove")
        adapter.add("БАРТОЛЕЦ Карло")
        adapter.add("БЫСТРОВ Марат")
        adapter.add("ВОРОГОВСКИЙ Ян")
        adapter.add("БЕЙСЕБЕКОВ Абзал")
        adapter.add("ШОМКО Дмитрий")
        adapter.add("МАРОЧКИН Александр")
        adapter.add("МАТА Луиш Карлош Машаду")
        adapter.add("ҚАСАБҰЛАТ Дамир")
        adapter.add("МАРТЫНОВИЧ Александр")
        adapter.add("ТАПАЛОВ Еркін")
        adapter.add("ЕРЛАНОВ Темірлан")
        adapter.add("ҚАСЫМ Әлібек")
        adapter.add("КИКИ Габи Жуниор")
        adapter.add("АНТИЧ Никола")
        adapter.add("АСТАНОВ Сұлтанбек")
        adapter.add("МАЛЫЙ Сергей")



        val db = db(this, null)

        search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean = false

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.filter.filter(newText)
                return true
            }
        })


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
            val selected = p.selectedPlayerId
            val name = parent.getItemAtPosition(position).toString()
            if (name == "Remove" && checkMoney(selected, 0) >= 0){
                db.updatePlayerImage(p.selectedPlayerId, R.drawable._348811, "Null", "0")
            }
            else if ((name == "БАРТОЛЕЦ Карло") && db.isNameFree(R.drawable.bartole)){
                if (checkMoney(selected, 11000) >= 0) {
                    db.updatePlayerImage(p.selectedPlayerId, R.drawable.bartole, "БАРТОЛЕЦ Карло", "11000")
                }
            }
            else if (name == "БЫСТРОВ Марат" && db.isNameFree(R.drawable.bistr)){
                if (checkMoney(selected, 11000) >= 0) {
                    db.updatePlayerImage(p.selectedPlayerId, R.drawable.bistr, "БЫСТРОВ Марат", "11000")
                }
            }
            else if (name == "ВОРОГОВСКИЙ Ян" && db.isNameFree(R.drawable.voro)) {
                if (checkMoney(selected, 11500) >= 0) {
                    db.updatePlayerImage(p.selectedPlayerId, R.drawable.voro, "ВОРОГОВСКИЙ Ян", "11500")
                }
            }
            else if (name == "БЕЙСЕБЕКОВ Абзал" && db.isNameFree(R.drawable.abzal)) {
                if (checkMoney(selected, 10500) >= 0) {
                    db.updatePlayerImage(p.selectedPlayerId, R.drawable.abzal, "БЕЙСЕБЕКОВ Абзал", "10500")
                }
            }
            else if (name == "ШОМКО Дмитрий" && db.isNameFree(R.drawable.shomko)) {
                if (checkMoney(selected, 10500) >= 0) {
                    db.updatePlayerImage(p.selectedPlayerId, R.drawable.shomko, "ШОМКО Дмитрий", "10500")
                }
            }
            else if (name == "МАРОЧКИН Александр" && db.isNameFree(R.drawable.maro)) {
                if (checkMoney(selected, 12000) >= 0) {
                    db.updatePlayerImage(p.selectedPlayerId, R.drawable.maro, "МАРОЧКИН Александр", "12000")
                }
            }
            else if (name == "МАТА Луиш Карлош Машаду" && db.isNameFree(R.drawable.mata)) {
                if (checkMoney(selected, 12500) >= 0) {
                    db.updatePlayerImage(p.selectedPlayerId, R.drawable.mata, "МАТА Луиш Карлош Машаду", "12500")
                }
            }
            else if (name == "ҚАСАБҰЛАТ Дамир" && db.isNameFree(R.drawable.kassa)) {
                if (checkMoney(selected, 14000) >= 0) {
                    db.updatePlayerImage(p.selectedPlayerId, R.drawable.kassa, "ҚАСАБҰЛАТ Дамир", "14000")
                }
            }
            else if (name == "МАРТЫНОВИЧ Александр" && db.isNameFree(R.drawable.martin)) {
                if (checkMoney(selected, 15000) >= 0) {
                    db.updatePlayerImage(p.selectedPlayerId, R.drawable.martin, "МАРТЫНОВИЧ Александр", "15000")
                }
            }
            else if (name == "ТАПАЛОВ Еркін" && db.isNameFree(R.drawable.tapal)) {
                if (checkMoney(selected, 15000) >= 0) {
                    db.updatePlayerImage(p.selectedPlayerId, R.drawable.tapal, "ТАПАЛОВ Еркін", "15000")
                }
            }
            else if (name == "ЕРЛАНОВ Темірлан" && db.isNameFree(R.drawable.erlan)) {
                if (checkMoney(selected, 10000) >= 0) {
                    db.updatePlayerImage(p.selectedPlayerId, R.drawable.erlan, "ЕРЛАНОВ Темірлан", "10000")
                }
            }
            else if (name == "ҚАСЫМ Әлібек" && db.isNameFree(R.drawable.kasim)) {
                if (checkMoney(selected, 14000) >= 0) {
                    db.updatePlayerImage(p.selectedPlayerId, R.drawable.kasim, "ҚАСЫМ Әлібек", "14000")
                }
            }
            else if (name == "КИКИ Габи Жуниор" && db.isNameFree(R.drawable.kiki)) {
                if (checkMoney(selected, 13000) >= 0) {
                    db.updatePlayerImage(p.selectedPlayerId, R.drawable.kiki, "КИКИ Габи Жуниор", "13000")
                }
            }
            else if (name == "АНТИЧ Никола" && db.isNameFree(R.drawable.antich)) {
                if (checkMoney(selected, 11500) >= 0) {
                    db.updatePlayerImage(p.selectedPlayerId, R.drawable.antich, "АНТИЧ Никола", "11500")
                }
            }
            else if (name == "МАЛЫЙ Сергей" && db.isNameFree(R.drawable.mal)) {
                if (checkMoney(selected, 8000) >= 0) {
                    db.updatePlayerImage(p.selectedPlayerId, R.drawable.mal, "МАЛЫЙ Сергей", "8000")
                }
            }
            else if (name == "АСТАНОВ Сұлтанбек" && db.isNameFree(R.drawable.astanov)) {
                if (checkMoney(selected, 13500) >= 0) {
                    db.updatePlayerImage(p.selectedPlayerId, R.drawable.astanov, "АСТАНОВ Сұлтанбек", "13500")
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