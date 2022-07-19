package First_Android.ActivityLifeCycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.firstAndroid.R

class DialogActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog_life_cycle)
    }
}