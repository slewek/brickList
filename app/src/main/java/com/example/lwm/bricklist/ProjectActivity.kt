package com.example.lwm.bricklist

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class ProjectActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_project)

        val extras = intent.extras ?: return
        val project = extras.getString("project")
        println(project)
    }
}
