package First_Android.JSONObject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.firstAndroid.R
import kotlinx.android.synthetic.main.activity_main_jsonobject.*
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
}