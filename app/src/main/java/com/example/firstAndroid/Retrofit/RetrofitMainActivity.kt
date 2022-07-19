package com.example.firstAndroid.Retrofit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.firstAndroid.ActivityLifeCycle.ActivityLifeCycleMainActivity
import com.example.firstAndroid.HttpURLConnection.HttpURLConnectionMainActivity
import com.example.firstAndroid.JSONObject.JSONObjectMainActivity
import com.example.firstAndroid.OkHttp.OkHttpMainActivity
import com.example.firstAndroid.R
import kotlinx.android.synthetic.main.activity_main_retrofit.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitMainActivity : AppCompatActivity() {
    private val TAG = "Retrofit"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_retrofit)
        sendRequestBtn_retrofit.setOnClickListener {
            var informations = ""

            val retrofit = Retrofit.Builder()
                .baseUrl("http://10.79.166.221/")
//                .baseUrl("http://192.168.0.102/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

//            val appService = retrofit.create(AppService::class.java)
//
//            appService.getAppData().enqueue(object : Callback<List<App>>{
//                override fun onResponse(call: Call<List<App>>, response: Response<List<App>>) {
//                    val list = response.body()
//                    if(list != null){
//                        for(app in list){
//                            information = stringAdd(information,
//                                "The id is ${app.id},the name is ${app.name},the version is ${app.version}")
//                            Log.d(TAG,"id is ${app.id}")
//                            Log.d(TAG,"name is ${app.name}")
//                            Log.d(TAG,"version is ${app.version}")
//                            Log.d(TAG,"infor is $information")
//                        }
//                        showResponse(information)
//                    }
//                }
//
//                override fun onFailure(call: Call<List<App>>, t: Throwable) {
//                    t.printStackTrace()
//                }
//            })

            val appService = retrofit.create(informationService::class.java)

            appService.getInformationData().enqueue(object : Callback<List<information>>{
                override fun onResponse(call: Call<List<information>>, response: Response<List<information>>) {
                    val list = response.body()
                    if(list != null){
                        for(infor in list){
                            Log.d(TAG,"it is ${infor.picture}")
                            informations = stringAdd(informations,
                                "The picture is ${infor.picture} \n" +
                                        "The title is ${infor.title} \n" +
                                        "The author is ${infor.author}" +
                                        "The update is ${infor.update} \n" +
                                        "The type is ${infor.type} \n" +
                                        "The good is ${infor.good} \n" + "The watch is ${infor.watch} \n" +
                                        "The top is ${infor.top}")
                            Log.d(TAG,"infor is $informations")
                        }
                        showResponse(informations)
                    }
                }

                override fun onFailure(call: Call<List<information>>, t: Throwable) {
                    t.printStackTrace()
                }
            })
        }
    }

    private fun stringAdd(string1: String, string2: String): String{
        return string1+"\n"+"---------------------------------------------\n"+string2
    }

    private fun showResponse(response: String) {
        runOnUiThread {
            responseText_retrofit.text = response
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

            R.id.JSONObject -> {
                val intent = Intent()
                intent.setClass(this, JSONObjectMainActivity::class.java)
                startActivity(intent)
                finish()
                Toast.makeText(this,"Jump to JSONObject", Toast.LENGTH_SHORT).show()
            }
        }
        return true
    }
}