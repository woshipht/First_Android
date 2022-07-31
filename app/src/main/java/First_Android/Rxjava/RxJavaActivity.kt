package First_Android.Rxjava

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.firstAndroid.R
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_rx_java.*

class RxJavaActivity : AppCompatActivity() {
    companion object{
        var infor = ""
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rx_java)

        button_rxjava.setOnClickListener {
//            normalCall()
            streamCall()

            textView_rxjava.text = infor
            infor = ""
        }
    }

    private fun normalCall(){
        //创建被观察者，以及其发出的事件
        var observable = Observable.create<Int> {
            it.onNext(1)
            it.onNext(2)
            it.onNext(3)
            it.onComplete()
        }

        //创建观察者
        var observer = object : Observer<Int> {
            override fun onSubscribe(d: Disposable) {
                infor += "开始采用subscribe连接\n"
            }

            override fun onNext(t: Int) {
                infor += "对Next事件${t}作出响应\n"
            }

            override fun onError(e: Throwable) {
                infor += "对Error事件作出响应\n"
            }

            override fun onComplete() {
                infor += "对Complete事件作出响应\n"
            }
        }

        //连接观察者和被观察者
        observable.subscribe(observer)
    }

    private fun streamCall(){
        Observable.create<Int> {
            it.onNext(1)
            it.onNext(2)
            it.onNext(3)
            it.onComplete()
        }.subscribe(object : Observer<Int>{
            override fun onSubscribe(d: Disposable) {
                infor += "开始采用subscribe连接\n"
            }

            override fun onNext(t: Int) {
                infor += "对Next事件${t}作出响应\n"
            }

            override fun onError(e: Throwable) {
                infor += "对Error事件作出响应\n"
            }

            override fun onComplete() {
                infor += "对Complete事件作出响应\n"
            }
        })
    }
}