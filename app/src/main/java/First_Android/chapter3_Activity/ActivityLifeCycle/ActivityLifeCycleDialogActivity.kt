package First_Android.chapter3_Activity.ActivityLifeCycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.firstAndroid.R

class ActivityLifeCycleDialogActivity : AppCompatActivity() {
    companion object {
        private const val TAG = "ActivitiesLifeCycle"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog_life_cycle)
        Log.d(TAG,"DialogActivity_onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG,"DialogActivity_onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG,"DialogActivity_onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG,"DialogActivity_onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"DialogActivity_onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"DialogActivity_onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG,"DialogActivity_onRestart")
    }
}