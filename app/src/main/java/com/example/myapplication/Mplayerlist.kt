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

class Mplayerlist : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_mplayerlist)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val list = findViewById<ListView>(R.id.list2)
        val q = mutableListOf<String>()
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, q)
        val search = findViewById<SearchView>(R.id.searchViewm)
        list.adapter = adapter
        adapter.add("Remove")
        adapter.add("ЗАРИЯ Гиорги")
        adapter.add("ГРИПШИ Назми")
        adapter.add("ЭБОНГ Макс")
        adapter.add("ТАГЫБЕРГЕН Асхат")
        adapter.add("СЕЙДАХМЕТ Еркебулан")

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
            if (name == "ЗАРИЯ Гиорги" && db.isNameFree(R.drawable.zaria)) {
                if (checkMoney(selected, 12000) >= 0) {
                    db.updatePlayerImage(p.selectedPlayerId, R.drawable.zaria, "ЗАРИЯ Гиорги", "12000")
                }
            }
            else if (name == "ГРИПШИ Назми" && db.isNameFree(R.drawable.gripshi)) {
                if (checkMoney(selected, 13000) >= 0) {
                    db.updatePlayerImage(p.selectedPlayerId, R.drawable.gripshi, "ГРИПШИ Назми", "13000")
                }
            }
            else if (name == "Remove" && checkMoney(selected, 0) >= 0){
                db.updatePlayerImage(p.selectedPlayerId, R.drawable._348811, "Null", "0")
            }
            else if (name == "ЭБОНГ Макс" && db.isNameFree(R.drawable.ebong)) {
                if (checkMoney(selected, 9500) >= 0) {
                    db.updatePlayerImage(p.selectedPlayerId, R.drawable.ebong, "ЭБОНГ Макс", "9500")
                }
            }
            else if (name == "ТАГЫБЕРГЕН Асхат" && db.isNameFree(R.drawable.ashat)) {
                if (checkMoney(selected, 10500) >= 0) {
                    db.updatePlayerImage(p.selectedPlayerId, R.drawable.ashat, "ТАГЫБЕРГЕН Асхат", "10500")
                }
            }
            else if (name == "СЕЙДАХМЕТ Еркебулан" && db.isNameFree(R.drawable.seidahmet)) {
                if (checkMoney(selected, 8500) >= 0) {
                    db.updatePlayerImage(p.selectedPlayerId, R.drawable.seidahmet, "СЕЙДАХМЕТ Еркебулан", "8500")
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