package com.example.myapplication

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class db(val context: Context, val factory: SQLiteDatabase.CursorFactory?) :
    SQLiteOpenHelper(context, "app", factory, 1) {

    override fun onCreate(db: SQLiteDatabase?) {
        val comand =
            "CREATE TABLE users (id INT PRIMARY KEY, login TEXT, gmail TEXT, password TEXT)"
        db!!.execSQL(comand)




        val comands =
            "CREATE TABLE score (id INT PRIMARY KEY, game INT, overall REAL)"
        db!!.execSQL(comands)


        val valuess = ContentValues()
        valuess.put("id", 1)
        valuess.put("game", 0)
        valuess.put("overall", 0.0)
        db.insert("score", null, valuess)


        val players = "CREATE TABLE players (id INT PRIMARY KEY, img INT, name TEXT, money TEXT)"
        db.execSQL(players)
        for (i in 1..11) {
            val values = ContentValues()
            values.put("id", i)
            values.put("img", R.drawable._348811)
            values.put("name", "Null")
            values.put("money", "0")

            db.insert("players", null, values)
        }

        //таблица для хранения общего баланса
        val money = "CREATE TABLE money (id INT PRIMARY KEY, amount INT)"
        db.execSQL(money)


        val values = ContentValues()
        values.put("id", 1)
        values.put("amount", 110000)
        db.insert("money", null, values)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS users")
        db!!.execSQL("DROP TABLE IF EXISTS players")
        db!!.execSQL("DROP TABLE IF EXISTS money")

        onCreate(db)

    }

    // Возвращает true, если игрок с таким name НЕ встречается в текущих 11 слотах players
    fun isNameFree(img: Int): Boolean {
        val db = readableDatabase
        val cursor =
            db.rawQuery("SELECT COUNT(*) FROM players WHERE img = ?", arrayOf(img.toString()))
        cursor.moveToFirst()
        val count = cursor.getInt(0)
        cursor.close()
        db.close()
        return count == 0
    }


    fun addUser(user: register) {
        val values = ContentValues()
        values.put("login", user.name)
        values.put("gmail", user.gmail)
        values.put("password", user.password)

        val db = this.writableDatabase
        db.insert("users", null, values)
        db.close()
    }

    fun getUser(login: String, password: String): Boolean {
        val db = this.readableDatabase

        val result = db.rawQuery(
            "SELECT * FROM users WHERE login = '$login' AND password = '$password'",
            null
        )
        return result.moveToFirst()
    }

    fun updatePlayerImage(id: Int, newpng: Int, newname: String, newmoney: String) {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put("img", newpng)
        values.put("name", newname)
        values.put("money", newmoney)
        db.update("players", values, "id=$id", null)
        db.close()
    }

    fun getPlayerImage(id: Int): Int {
        val db = this.readableDatabase
        val result = db.rawQuery("SELECT * FROM players WHERE id = '$id'", null)
        var q = R.drawable._348811
        if (result.moveToFirst()) {
            q = result.getInt(result.getColumnIndexOrThrow("img"))
        }
        result.close()
        db.close()
        return q
    }

    fun getPlayerName(id: Int): String {
        val db = this.readableDatabase
        val result = db.rawQuery("SELECT * FROM players WHERE id = '$id'", null)
        var q = "Null"
        if (result.moveToFirst()) {
            q = result.getString(result.getColumnIndexOrThrow("name"))
        }
        result.close()
        db.close()
        return q
    }

    fun getPlayerMoney(id: Int): String {
        val db = this.readableDatabase
        val result = db.rawQuery("SELECT * FROM players WHERE id = '$id'", null)
        var q = "0"
        if (result.moveToFirst()) {
            q = result.getString(result.getColumnIndexOrThrow("money"))
        }
        result.close()
        db.close()

        return q
    }


    fun getMoney(): Int {
        val cursor = readableDatabase.rawQuery("SELECT amount FROM money WHERE id = 1", null)
        return if (cursor.moveToFirst()) cursor.getInt(0) else 110000
            .also { cursor.close() }
    }

    fun setMoney(value: Int) {
        val values = ContentValues()
        values.put("amount", value)
        writableDatabase.update("money", values, "id = ?", arrayOf("1"))
    }




    
    }























