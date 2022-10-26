package First_Android.chapter3_Activity.ActivityCollector

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

/**
 *  将所有打开的Activity加入到一个管理器类中，当退出任意Activity时，所有Activity都会被关闭
 */
open class ActivityCollectorMainActivity:AppCompatActivity() {
    companion object{
        private const val TAG = "ActivityCollector"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG,javaClass.simpleName)
        ActivityCollector.addActivity(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        ActivityCollector.removeActivity(this)
    }
}