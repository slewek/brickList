package com.example.lwm.bricklist

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_add_project.*
import java.io.File
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException
import java.net.MalformedURLException
import java.net.URL

class AddProjectActivity : AppCompatActivity() {

    var adress = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_project)

        val extras = intent.extras ?: return
        adress = extras.getString("adress")
    }

    fun addClick(v: View) {
        loadXML()
    }

    fun loadXML() {
        val thread = Thread(Runnable {
            try {
                val url = URL("http://" + adress + numberText.text + ".xml")
                val connection = url.openConnection()
                connection.connect()
                val lengthOfFile = connection.contentLength
                val isStream = url.openStream()
                val directory = File("$filesDir/XML")
                if (!directory.exists()) {
                    directory.mkdir()
                }
                val fos = FileOutputStream("$directory/" + numberText.text + ".xml")
                val data = ByteArray(1024)
                var count = 0
                var total: Long = 0
                var progress = 0
                count = isStream.read(data)
                while (count != -1) {
                    total += count.toLong()
                    val progress_temp = total.toInt() * 100 / lengthOfFile
                    if (progress_temp % 10 == 0 && progress != progress_temp) {
                        progress = progress_temp
                    }
                    fos.write(data, 0, count)
                    count = isStream.read(data)
                }
                isStream.close()
                fos.close()
            } catch (e: MalformedURLException) {
                println(e.toString())
            } catch (e: FileNotFoundException) {
                println(e.toString())
            } catch (e: IOException) {
                println(e.toString())
            }
        })
        thread.start()
        thread.interrupt()
    }
}
