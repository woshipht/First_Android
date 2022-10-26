package First_Android.chapter3_Activity.ActivityLifeCycle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.firstAndroid.R
import kotlinx.android.synthetic.main.activity_main_life_cycle.*

/**
 * 用于测试Activity的生命周期
 */
class ActivityLifeCycleMainActivity : AppCompatActivity() {
    companion object {
        private const val TAG = "ActivitiesLifeCycle"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_life_cycle)
        Log.d(TAG,"MainActivity_onCreate")

        startNormalActivity.setOnClickListener {
            val intent = Intent(this,ActivityLifeCycleNormalActivity::class.java)
            startActivity(intent)
            Toast.makeText(this,"To Normal Activity",Toast.LENGTH_SHORT).show()
        }

        startDialogActivity.setOnClickListener {
            val intent = Intent(this,ActivityLifeCycleDialogActivity::class.java)
            startActivity(intent)
            Toast.makeText(this,"To Dialog Activity",Toast.LENGTH_SHORT).show()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG,"MainActivity_onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG,"MainActivity_onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG,"MainActivity_onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"MainActivity_onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"MainActivity_onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG,"MainActivity_onRestart")
    }
}