package First_Android.ActivityCollector

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.example.firstAndroid.R
import kotlinx.android.synthetic.main.activity_main_activity_controller_first.*

class FirstActivityOfActivityCollector : BaseActivity() {
    companion object{
        private fun goNextActivity(context: Context){
            val intent = Intent()
            intent.setClass(context,SecondActivityOfActivityCollector::class.java)
            context.startActivity(intent)
            Toast.makeText(context, "Jump to Second Activity", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_activity_controller_first)
        OpenActivity.setOnClickListener {
            goNextActivity(this)
        }
        CloseAllActivity.setOnClickListener {
            ActivityCollector.finishAll()
        }
    }

}