package First_Android.chapter3_Activity.ActivityLifeCycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.firstAndroid.R

class ActivityLifeCycleNormalActivity : AppCompatActivity() {
    companion object {
        private const val TAG = "ActivitiesLifeCycle"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_normal_life_cycle)
        Log.d(TAG,"NormalActivity_onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG,"NormalActivity_onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG,"NormalActivity_onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG,"NormalActivity_onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"NormalActivity_onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"NormalActivity_onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG,"NormalActivity_onRestart")
    }
}