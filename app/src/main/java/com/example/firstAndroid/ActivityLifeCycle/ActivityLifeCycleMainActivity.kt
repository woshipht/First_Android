package com.example.firstAndroid.ActivityLifeCycle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.firstAndroid.HttpURLConnection.HttpURLConnectionMainActivity
import com.example.firstAndroid.JSONObject.JSONObjectMainActivity
import com.example.firstAndroid.OkHttp.OkHttpMainActivity
import com.example.firstAndroid.R
import com.example.firstAndroid.Retrofit.RetrofitMainActivity
import kotlinx.android.synthetic.main.activity_main_life_cycle.*

class ActivityLifeCycleMainActivity : AppCompatActivity() {
    private val tag = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_life_cycle)
        Log.d(tag,"onCreate")

        startNormalActivity.setOnClickListener {
            val intent = Intent(this,NormalActivity::class.java)
            startActivity(intent)
            Toast.makeText(this,"To Normal Activity",Toast.LENGTH_SHORT).show()
        }

        startDialogActivity.setOnClickListener {
            val intent = Intent(this,DialogActivity::class.java)
            startActivity(intent)
            Toast.makeText(this,"To Dialog Activity",Toast.LENGTH_SHORT).show()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(tag,"onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(tag,"onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(tag,"onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(tag,"onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(tag,"onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(tag,"onRestart")
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.HttpURLConnection -> {
                val intent = Intent()
                intent.setClass(this,HttpURLConnectionMainActivity::class.java)
                startActivity(intent)
                finish()
                Toast.makeText(this,"Jump to HttpURLConnection", Toast.LENGTH_SHORT).show()
            }

            R.id.OkHttp -> {
                val intent = Intent()
                intent.setClass(this,OkHttpMainActivity::class.java)
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