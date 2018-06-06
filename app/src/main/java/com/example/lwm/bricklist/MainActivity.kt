package com.example.lwm.bricklist

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File

class MainActivity : AppCompatActivity() {

    val REQUEST_CODE = 1000
    val SETTING_CODE = 1001
    var adress = "fcds.cs.put.poznan.pl/MyWeb/BL/"

    val projects = arrayListOf<String>()
    lateinit var listView : ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.listView1)
        File("$filesDir/XML").walk().forEach {
            projects.add(it.toString())
        }
        listView.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,projects)

        listView.setOnItemClickListener{
            parent : AdapterView<*>?, view : View?, position : Int, id : Long ->
            val i = Intent(this, ProjectActivity::class.java)
            i.putExtra("project", projects[position])
            startActivityForResult(i, SETTING_CODE)
        }


    }

    fun addOnClick(v: View) {
        val i = Intent(this, AddProjectActivity::class.java)
        i.putExtra("adress", adress)
        startActivityForResult(i, REQUEST_CODE)
    }

    fun settingsOnClick(v: View) {
        val i = Intent(this, SettingActivity::class.java)
        i.putExtra("adress", adress)
        startActivityForResult(i, SETTING_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if ((requestCode == SETTING_CODE)
                && (resultCode == Activity.RESULT_OK)) {
            if (data != null) {
                if(data.hasExtra("adress")){
                    adress = data.extras.getString("adress")
                }
            }
        }

    }
}
