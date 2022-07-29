package Data

import First_Android.ActivityCollector.FirstActivityOfActivityCollector
import First_Android.ActivityLifeCycle.ActivityLifeCycleMainActivity
import First_Android.HttpURLConnection.HttpURLConnectionMainActivity
import First_Android.JSONObject.JSONObjectMainActivity
import First_Android.OkHttp.OkHttpMainActivity
import First_Android.Retrofit.RetrofitMainActivity
import First_Android.viewModel.ViewModelActivity
import com.example.firstAndroid.R

object MenuList {
    private val menuList = mutableSetOf<MenuItemInfo>()

    init {
        menuList.add(MenuItemInfo(R.id.ActivityLifeCycle, ActivityLifeCycleMainActivity::class.java,"ActivityLifeCycle"))
        menuList.add(MenuItemInfo(R.id.HttpURLConnection, HttpURLConnectionMainActivity::class.java,"HttpURLConnection"))
        menuList.add(MenuItemInfo(R.id.OkHttp, OkHttpMainActivity::class.java,"OkHttp"))
        menuList.add(MenuItemInfo(R.id.JSONObject, JSONObjectMainActivity::class.java,"JSONObject"))
        menuList.add(MenuItemInfo(R.id.Retrofit, RetrofitMainActivity::class.java,"Retrofit"))
        menuList.add(MenuItemInfo(R.id.ActivityCollector, FirstActivityOfActivityCollector::class.java,"ActivityCollector"))
        menuList.add(MenuItemInfo(R.id.ViewModel, ViewModelActivity::class.java,"ViewModel"))
    }

    fun getMenuList(): MutableSet<MenuItemInfo> {
        return menuList
    }
}