package Data

import First_Android.ActivityLifeCycle.ActivityLifeCycleMainActivity
import First_Android.HttpURLConnection.HttpURLConnectionMainActivity
import First_Android.JSONObject.JSONObjectMainActivity
import First_Android.OkHttp.OkHttpMainActivity
import First_Android.Retrofit.RetrofitMainActivity
import android.util.Log
import com.example.firstAndroid.R

object MenuList {
    private val menuList = mutableSetOf<MenuItemInfo>()

    init {
        Log.d("pht","test")
        menuList.add(MenuItemInfo(R.id.ActivityLifeCycle, ActivityLifeCycleMainActivity::class.java,"ActivityLifeCycle"))
        menuList.add(MenuItemInfo(R.id.HttpURLConnection, HttpURLConnectionMainActivity::class.java,"HttpURLConnection"))
        menuList.add(MenuItemInfo(R.id.OkHttp, OkHttpMainActivity::class.java,"OkHttp"))
        menuList.add(MenuItemInfo(R.id.JSONObject, JSONObjectMainActivity::class.java,"JSONObject"))
        menuList.add(MenuItemInfo(R.id.Retrofit, RetrofitMainActivity::class.java,"Retrofit"))
        menuList.add(MenuItemInfo(R.id.Retrofit, RetrofitMainActivity::class.java,"Retrofit"))
    }

    fun getMenuList(): MutableSet<MenuItemInfo> {
        return menuList
    }
}