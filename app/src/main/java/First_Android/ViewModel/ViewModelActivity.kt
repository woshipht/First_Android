package First_Android.ViewModel

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.firstAndroid.R
import kotlinx.android.synthetic.main.activity_view_model.*
import java.util.zip.Inflater

class ViewModelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_model)

        val userVM = ViewModelProviders.of(this)[UserModel::class.java]

        userVM.mUserLiveData.observe(this, Observer{
            textView_viewModel.text = it.toString()
        })

        button_viewModel.setOnClickListener {
            userVM.doSomething()
        }
    }
}