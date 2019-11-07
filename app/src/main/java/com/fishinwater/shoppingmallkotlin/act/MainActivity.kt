package com.fishinwater.shoppingmallkotlin.act

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fishinwater.shoppingmallkotlin.R
import com.fishinwater.shoppingmallkotlin.fragment.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mBottomBar.checkCartBadge(20)
        mBottomBar.checkMsgBadge(false)
        Observable.timer(2, TimeUnit.SECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe{ mBottomBar.checkCartBadge(0) }
        Observable.timer(2, TimeUnit.SECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe{ mBottomBar.checkMsgBadge(true) }
        iniView()
    }

    private fun iniView() {
        var manager = supportFragmentManager.beginTransaction()
        manager.replace(R.id.mContainer, HomeFragment())
        manager.commit()
    }
}
