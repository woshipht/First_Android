package com.example.firstAndroid.OkHttp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.firstAndroid.ActivityLifeCycle.ActivityLifeCycleMainActivity
import com.example.firstAndroid.HttpURLConnection.HttpURLConnectionMainActivity
import com.example.firstAndroid.JSONObject.JSONObjectMainActivity
import com.example.firstAndroid.R
import com.example.firstAndroid.Retrofit.RetrofitMainActivity
import kotlinx.android.synthetic.main.activity_main_okhttp.*
import okhttp3.OkHttpClient
import okhttp3.Request
import java.lang.Exception
import kotlin.concurrent.thread

class OkHttpMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_okhttp)
        sendRequestBtn_okhttp.setOnClickListener {
            sendRequestWithOkHttp()
        }
    }

    private fun sendRequestWithOkHttp(){
        thread {
            try {
                val client = OkHttpClient()
                val request = Request.Builder()
                    .url("https://www.baidu.com")
                    .build()
                val response = client.newCall(request).execute()
                val responseData = response.body?.string()
                responseData?.let { showResponse(it) }
//                if (responseData != null){
//                    showResponse(responseData)
//                }
            }catch (e: Exception){
                e.printStackTrace()
            }
        }
    }

    private fun showResponse(response: String) {
        runOnUiThread {
            responseText_okhttp.text = response
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

            R.id.HttpURLConnection -> {
                val intent = Intent()
                intent.setClass(this, HttpURLConnectionMainActivity::class.java)
                startActivity(intent)
                finish()
                Toast.makeText(this,"Jump to HttpURLConnection", Toast.LENGTH_SHORT).show()
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