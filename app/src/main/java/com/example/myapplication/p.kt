package com.example.myapplication

import android.content.Context

object p {
    var selectedPlayerId: Int = 1

    private lateinit var database: db

    fun init(context: Context) {
        database = db(context, null)
    }

    var restMoney: Int
        get() = database.getMoney()
        set(value) {
            database.setMoney(value)
        }
}
