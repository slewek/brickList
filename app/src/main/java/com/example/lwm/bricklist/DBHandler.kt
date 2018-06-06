package com.example.lwm.bricklist

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHandler(context : Context, name : String?,
                factory: SQLiteDatabase.CursorFactory?, version:Int) : SQLiteOpenHelper(context, DATABASE_NAME,factory, DATABASE_VERSION){
    companion object {
        private val DATABASE_VERSION=1
        private val DATABASE_NAME = ""

    }

    override fun onCreate(p0: SQLiteDatabase?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}