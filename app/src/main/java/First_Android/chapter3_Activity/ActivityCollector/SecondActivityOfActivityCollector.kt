package First_Android.chapter3_Activity.ActivityCollector

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.example.firstAndroid.R
import kotlinx.android.synthetic.main.activity_main_activity_controller_second.*

class SecondActivityOfActivityCollector : ActivityCollectorMainActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_activity_controller_second)
        OpenActivity.setOnClickListener {
            goNextActivity()
        }
        CloseAllActivity.setOnClickListener {
            ActivityCollector.finishAll()
        }
    }

    private fun goNextActivity(){
        val intent = Intent()
        intent.setClass(this,ThirdActivityOfActivityCollector::class.java)
        startActivity(intent)
        Toast.makeText(this, "Jump to Third Activity", Toast.LENGTH_SHORT).show()
    }

}