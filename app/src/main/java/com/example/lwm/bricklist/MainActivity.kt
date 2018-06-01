package com.example.lwm.bricklist

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    var REQUEST_CODE = 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun addOnClick(v : View){
        val i = Intent(this, AddProjectActivity::class.java)
        startActivityForResult(i,REQUEST_CODE)
    }

    fun settingsOnClick(v : View){
        val i = Intent(this,SettingActivity::class.java)
        startActivityForResult(i,REQUEST_CODE)
    }
}
