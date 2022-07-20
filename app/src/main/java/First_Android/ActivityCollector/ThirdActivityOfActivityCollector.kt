package First_Android.ActivityCollector

import android.os.Bundle
import com.example.firstAndroid.R
import kotlinx.android.synthetic.main.activity_main_activity_controller_third.*

class ThirdActivityOfActivityCollector : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_activity_controller_third)
        CloseAllActivity.setOnClickListener {
            ActivityCollector.finishAll()
        }
    }
}