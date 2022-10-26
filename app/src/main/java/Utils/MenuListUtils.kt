package Utils

import First_Android.chapter3_Activity.ActivityCollector.FirstActivityOfActivityCollector
import First_Android.chapter3_Activity.ActivityLifeCycle.ActivityLifeCycleMainActivity
import First_Android.HttpURLConnection.HttpURLConnectionMainActivity
import First_Android.JSONObject.JSONObjectMainActivity
import First_Android.OkHttp.OkHttpMainActivity
import First_Android.Retrofit.RetrofitMainActivity
import First_Android.Rxjava.RxJavaActivity
import First_Android.ViewModel.ViewModelActivity
import Model.MenuInfo
import com.example.firstAndroid.R

object MenuListUtils {
    private val menuList = mutableSetOf<MenuInfo>()

    init {
        menuList.add(MenuInfo(R.id.ActivityLifeCycle, ActivityLifeCycleMainActivity::class.java,"ActivityLifeCycle"))
        menuList.add(MenuInfo(R.id.HttpURLConnection, HttpURLConnectionMainActivity::class.java,"HttpURLConnection"))
        menuList.add(MenuInfo(R.id.OkHttp, OkHttpMainActivity::class.java,"OkHttp"))
        menuList.add(MenuInfo(R.id.JSONObject, JSONObjectMainActivity::class.java,"JSONObject"))
        menuList.add(MenuInfo(R.id.Retrofit, RetrofitMainActivity::class.java,"Retrofit"))
        menuList.add(MenuInfo(R.id.ActivityCollector, FirstActivityOfActivityCollector::class.java,"ActivityCollector"))
        menuList.add(MenuInfo(R.id.ViewModel, ViewModelActivity::class.java,"ViewModel"))
        menuList.add(MenuInfo(R.id.RxJava, RxJavaActivity::class.java,"RxJava"))
    }

    fun getMenuList(): MutableSet<MenuInfo> {
        return menuList
    }
}