package com.example.firstAndroid

import Data.MenuItemInfo
import Data.MenuList
import First_Android.ActivityLifeCycle.ActivityLifeCycleMainActivity
import First_Android.HttpURLConnection.HttpURLConnectionMainActivity
import First_Android.JSONObject.JSONObjectMainActivity
import First_Android.OkHttp.OkHttpMainActivity
import First_Android.Retrofit.RetrofitMainActivity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private val menuList = MenuList.getMenuList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initData()
    }

    private fun initData(){
        menuList.add(MenuItemInfo(R.id.HttpURLConnection,HttpURLConnectionMainActivity::class.java,"HttpURLConnection"))
        menuList.add(MenuItemInfo(R.id.OkHttp,OkHttpMainActivity::class.java,"OkHttp"))
        menuList.add(MenuItemInfo(R.id.JSONObject, JSONObjectMainActivity::class.java,"JSONObject"))
        menuList.add(MenuItemInfo(R.id.Retrofit, RetrofitMainActivity::class.java,"Retrofit"))
        menuList.add(MenuItemInfo(R.id.ActivityLifeCycle, ActivityLifeCycleMainActivity::class.java,"ActivityLifeCycle"))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        for (menu in menuList) {
            if (item.itemId == menu.MenuId) {
                val intent = Intent()
                intent.setClass(this, menu.MenuClass)
                startActivity(intent)
                Toast.makeText(this, "Jump to ${menu.MenuName}", Toast.LENGTH_SHORT).show()
            }
        }
        return true
    }
}