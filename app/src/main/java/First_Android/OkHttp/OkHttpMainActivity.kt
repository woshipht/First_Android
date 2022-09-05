package First_Android.OkHttp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import First_Android.ActivityLifeCycle.ActivityLifeCycleMainActivity
import First_Android.HttpURLConnection.HttpURLConnectionMainActivity
import First_Android.JSONObject.JSONObjectMainActivity
import com.example.firstAndroid.R
import First_Android.Retrofit.RetrofitMainActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_main_okhttp.*
import okhttp3.Call
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.IOException
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

    private fun sendRequestWithOkHttp() {
        thread {
            try {
                //1.定义Okhttp的client，表示我们使用Okhttp
                val client = OkHttpClient()
                //2.创建request，作为要访问的目标
                val request = Request.Builder()
                    .url("https://www.baidu.com").get().build()
                //3.创建call，作为发起的请求
                val call = client.newCall(request)
                //4.执行网络请求过程，有成功和失败的回调函数
                call.enqueue(object : okhttp3.Callback {
                    override fun onFailure(call: Call, e: IOException) {
                        Log.d("Okhttp", "Network Request Failed")
                    }

                    override fun onResponse(call: Call, response: Response) {
                        if (response.isSuccessful) {
                            doSomethingWhenSuccess(response)
                            Log.d("Okhttp", "Network Request Success")
                        }
                    }
                })

                //execute是同步方法，enqueue是异步方法
//                val response = call.execute()
//                doSomethingWhenSuccess(response)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    private fun doSomethingWhenSuccess(response : Response){
        response.body?.string()?.let { showResponse(it) }
    }

    private fun showResponse(response: String) {
        runOnUiThread {
            responseText_okhttp.text = response
        }
    }
}