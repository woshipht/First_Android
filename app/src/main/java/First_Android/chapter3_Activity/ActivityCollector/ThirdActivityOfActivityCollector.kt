package First_Android.chapter3_Activity.ActivityCollector

import android.os.Bundle
import com.example.firstAndroid.R
import kotlinx.android.synthetic.main.activity_main_activity_controller_third.*

class ThirdActivityOfActivityCollector : ActivityCollectorMainActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_activity_controller_third)
        CloseAllActivity.setOnClickListener {
            ActivityCollector.finishAll()
        }
    }
}