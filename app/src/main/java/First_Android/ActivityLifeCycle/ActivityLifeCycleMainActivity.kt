package First_Android.ActivityLifeCycle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import First_Android.HttpURLConnection.HttpURLConnectionMainActivity
import Data.MenuList
import Data.MenuItemInfo
import com.example.firstAndroid.R
import kotlinx.android.synthetic.main.activity_main_life_cycle.*

class ActivityLifeCycleMainActivity : AppCompatActivity() {
    private val tag = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_life_cycle)
        Log.d(tag,"onCreate")

        startNormalActivity.setOnClickListener {
            val intent = Intent(this,NormalActivity::class.java)
            startActivity(intent)
            Toast.makeText(this,"To Normal Activity",Toast.LENGTH_SHORT).show()
        }

        startDialogActivity.setOnClickListener {
            val intent = Intent(this,DialogActivity::class.java)
            startActivity(intent)
            Toast.makeText(this,"To Dialog Activity",Toast.LENGTH_SHORT).show()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(tag,"onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(tag,"onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(tag,"onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(tag,"onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(tag,"onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(tag,"onRestart")
    }

}