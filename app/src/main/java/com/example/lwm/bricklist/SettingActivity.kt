package com.example.lwm.bricklist

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_setting.*

class SettingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        val extras = intent.extras ?: return
        val adress = extras.getString("adress")
        editText.text.clear()
        editText.text.append(adress)
    }

    fun confirmClick(v: View){
        val data = Intent()
        data.putExtra("adress",editText.text.toString())
        setResult(Activity.RESULT_OK,data)
        finish()
    }

}
