package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.SearchView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Splayerlist : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splayerlist)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val list = findViewById<ListView>(R.id.list)
        val q = mutableListOf<String>()

        val search = findViewById<SearchView>(R.id.searchViews)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, q)
        list.adapter = adapter
        adapter.add("Remove")
        adapter.add("Усман Камара")
        adapter.add("Чинеду Чарльз Джеффри")
        adapter.add("Марин Томасов")
        adapter.add("Дастан Сатбаев")
        adapter.add("ЧЕСНОКОВ Ислам")
        adapter.add("ЭЛЬ МЕССАУДИ Ахмед")
        adapter.add("МАСЕДО Эвертон")
        adapter.add("ИМНАДЗЕ Лука")



        search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean = false

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.filter.filter(newText)
                return true
            }
        })





        val db = db(this, null)
        p.init(this)   //

        list.setOnItemClickListener { parent, view, position, id ->
            fun checkMoney(id : Int, money : Int) : Int{
                val q = p.restMoney

                val m = db.getPlayerMoney(id).toInt() - money
                if (p.restMoney + m >= 0){
                    p.restMoney += m
                }
                else{
                    Toast.makeText(this, "You do not have enough money", Toast.LENGTH_SHORT).show()
                }
                return (q + m)

            }
            val name = parent.getItemAtPosition(position).toString()
            val selected = p.selectedPlayerId
            if (name == "Усман Камара" && db.isNameFree(R.drawable.camara)) {
                if (checkMoney(selected, 14000) >= 0) {
                    db.updatePlayerImage(p.selectedPlayerId, R.drawable.camara, "Усман Камара", "14000")
                }
            }
            else if (name == "Чинеду Чарльз Джеффри" && db.isNameFree(R.drawable.chinedu)) {
                if (checkMoney(selected, 15000) >= 0) {
                    db.updatePlayerImage(p.selectedPlayerId, R.drawable.chinedu, "Чинеду Чарльз Джеффри", "15000")
                }
            }
            else if (name == "Remove" && checkMoney(selected, 0) >= 0){
                db.updatePlayerImage(p.selectedPlayerId, R.drawable._348811, "Null", "0")
            }
            else if (name == "Марин Томасов" && db.isNameFree(R.drawable.tomasov)) {
                if (checkMoney(selected, 12000) >= 0) {
                    db.updatePlayerImage(p.selectedPlayerId, R.drawable.tomasov, "Марин Томасов", "12000")
                }
            }
            else if (name == "Дастан Сатбаев" && db.isNameFree(R.drawable.satba)) {
                if (checkMoney(selected, 15000) >= 0) {
                    db.updatePlayerImage(p.selectedPlayerId, R.drawable.satba, "Дастан Сатбаев", "15000")
                }
            }
            else if (name == "ЧЕСНОКОВ Ислам" && db.isNameFree(R.drawable.chesnok)) {
                if (checkMoney(selected, 12000) >= 0) {
                    db.updatePlayerImage(p.selectedPlayerId, R.drawable.chesnok, "ЧЕСНОКОВ Ислам", "12000")
                }
            }
            else if (name == "ЭЛЬ МЕССАУДИ Ахмед" && db.isNameFree(R.drawable.elmessa)) {
                if (checkMoney(selected, 10000) >= 0) {
                    db.updatePlayerImage(p.selectedPlayerId, R.drawable.elmessa, "ЭЛЬ МЕССАУДИ Ахмед", "10000")
                }
            }
            else if (name == "МАСЕДО Эвертон" && db.isNameFree(R.drawable.everton)) {
                if (checkMoney(selected, 9000) >= 0) {
                    db.updatePlayerImage(p.selectedPlayerId, R.drawable.everton, "МАСЕДО Эвертон", "9000")
                }
            }
            else if (name == "ИМНАДЗЕ Лука" && db.isNameFree(R.drawable.imnadze)) {
                if (checkMoney(selected, 8500) >= 0) {
                    db.updatePlayerImage(p.selectedPlayerId, R.drawable.imnadze, "ИМНАДЗЕ Лука", "8500")
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