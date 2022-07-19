package com.example.firstAndroid.JSONObject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.firstAndroid.ActivityLifeCycle.ActivityLifeCycleMainActivity
import com.example.firstAndroid.HttpURLConnection.HttpURLConnectionMainActivity
import com.example.firstAndroid.OkHttp.OkHttpMainActivity
import com.example.firstAndroid.R
import com.example.firstAndroid.Retrofit.RetrofitMainActivity
import kotlinx.android.synthetic.main.activity_main_jsonobject.*
import kotlinx.android.synthetic.main.activity_main_okhttp.*
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONArray
import java.lang.Exception
import kotlin.concurrent.thread

class JSONObjectMainActivity : AppCompatActivity() {
    private val TAG = "JSONObject"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_jsonobject)
        sendRequestBtn_JSONObject.setOnClickListener {
            sendRequestWithOkHttp()
        }
    }

    private fun sendRequestWithOkHttp(){
        thread {
            try {
                val client = OkHttpClient()
                val request = Request.Builder()
                    .url("http://10.79.166.221/get_data.json")
                    .build()
                val response = client.newCall(request).execute()
                val responseData = response.body?.string()
                if (responseData != null){
                    parseJSONWithJSONObject(responseData)
                }
            }catch (e: Exception){
                e.printStackTrace()
                Log.d(TAG,"wtf")
            }
        }
    }

    private fun parseJSONWithJSONObject(jsonData: String){
        try {
            Log.d(TAG,"$jsonData")
            val jsonArray = JSONArray(jsonData)
            var information = ""
            for(i in 0 until jsonArray.length()){
                val jsonObject = jsonArray.getJSONObject(i)
                val id = jsonObject.getString("id")
                val name = jsonObject.getString("name")
                val version = jsonObject.getString("version")
                information = stringAdd(information,
                    "The id is $id,the name is $name,the version is $version")
                Log.d(TAG,"id is $id")
                Log.d(TAG,"name is $name")
                Log.d(TAG,"version is $version")
            }
            showResponse(information)
        }catch (e: Exception){
            e.printStackTrace()
            Log.d(TAG,"??")
        }
    }

    private fun stringAdd(string1: String, string2: String): String{
        return string1+"\n"+string2
    }

    private fun showResponse(response: String) {
        runOnUiThread {
            responseText_JSONObject.text = response
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

            R.id.HttpURLConnection -> {
                val intent = Intent()
                intent.setClass(this, HttpURLConnectionMainActivity::class.java)
                startActivity(intent)
                finish()
                Toast.makeText(this,"Jump to HttpURLConnection", Toast.LENGTH_SHORT).show()
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