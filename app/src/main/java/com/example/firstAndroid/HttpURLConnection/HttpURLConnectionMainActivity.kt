package com.example.firstAndroid.HttpURLConnection

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.firstAndroid.ActivityLifeCycle.ActivityLifeCycleMainActivity
import com.example.firstAndroid.JSONObject.JSONObjectMainActivity
import com.example.firstAndroid.OkHttp.OkHttpMainActivity
import com.example.firstAndroid.R
import com.example.firstAndroid.Retrofit.RetrofitMainActivity
import kotlinx.android.synthetic.main.activity_main_http.*
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Exception
import java.net.HttpURLConnection
import java.net.URL
import kotlin.concurrent.thread

class HttpURLConnectionMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_http)

        sendRequestBtn.setOnClickListener {
            sendRequestWithHttpURLConnection()
        }
    }

    private fun sendRequestWithHttpURLConnection() {
        thread {
            var connection: HttpURLConnection? = null
            try {
                val response = StringBuilder()
                val url = URL("https://www.baidu.com")
                connection = url.openConnection() as HttpURLConnection
                connection.connectTimeout = 8000
                connection.readTimeout = 8000
                val input = connection.inputStream
                val reader = BufferedReader(InputStreamReader(input))
                reader.use {
                    reader.forEachLine {
                        response.append(it)
                    }
                }
                showResponse(response.toString())
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                connection?.disconnect()
            }
        }
    }

    private fun showResponse(response: String) {
        runOnUiThread {
            responseText.text = response
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.ActivityLifeCycle -> {
                val intent = Intent()
                intent.setClass(this, ActivityLifeCycleMainActivity::class.java)
                startActivity(intent)
                finish()
                Toast.makeText(this, "Jump to ActivityLifeCycle", Toast.LENGTH_SHORT).show()
            }

            R.id.OkHttp -> {
                val intent = Intent()
                intent.setClass(this, OkHttpMainActivity::class.java)
                startActivity(intent)
                finish()
                Toast.makeText(this,"Jump to OkHttp", Toast.LENGTH_SHORT).show()
            }

            R.id.JSONObject -> {
                val intent = Intent()
                intent.setClass(this, JSONObjectMainActivity::class.java)
                startActivity(intent)
                finish()
                Toast.makeText(this,"Jump to JSONObject", Toast.LENGTH_SHORT).show()
            }

            R.id.Retrofit -> {
                val intent = Intent()
                intent.setClass(this, RetrofitMainActivity::class.java)
                startActivity(intent)
                finish()
                Toast.makeText(this,"Jump to Retrofit", Toast.LENGTH_SHORT).show()
            }
        }
        return true
    }
}