package com.fishinwater.shoppingmallkotlin.widgets

import android.content.Context
import android.text.BoringLayout
import android.util.AttributeSet
import com.ashokvarma.bottomnavigation.BottomNavigationBar
import com.ashokvarma.bottomnavigation.BottomNavigationItem
import com.ashokvarma.bottomnavigation.ShapeBadgeItem
import com.ashokvarma.bottomnavigation.TextBadgeItem
import com.fishinwater.shoppingmallkotlin.R

class BottomNavBar  @JvmOverloads constructor (
    context : Context, attrs : AttributeSet?= null, defStyleAttr : Int = 0
) : BottomNavigationBar(context, attrs, defStyleAttr) {

    /**
     * 购物车 Tab 标签
     */
    private val mCartBadge : TextBadgeItem
    /**
     * 消息 Tab 标签
     */
    private val mMsgBadge : ShapeBadgeItem

    init {
        // 首页
        val homeItem = BottomNavigationItem(R.drawable.btn_nav_home_press, resources.getString(R.string.nav_bar_home))
            .setInactiveIconResource(R.drawable.btn_nav_home_nomal)
            .setActiveColorResource(R.color.colorPrimary)
            .setInActiveColorResource(R.color.colorPrimaryDark)

        // 首页
        val categoryItem = BottomNavigationItem(R.drawable.btn_nav_category_press, resources.getString(R.string.nav_bar_category))
            .setInactiveIconResource(R.drawable.btn_nav_category_press)
            .setActiveColorResource(R.color.colorPrimary)
            .setInActiveColorResource(R.color.colorPrimaryDark)

        // 首页
        val cartItem = BottomNavigationItem(R.drawable.btn_nav_cart_press, resources.getString(R.string.nav_bar_cart))
            .setInactiveIconResource(R.drawable.btn_nav_cart_normal)
            .setActiveColorResource(R.color.colorPrimary)
            .setInActiveColorResource(R.color.colorPrimaryDark)

        mCartBadge = TextBadgeItem()
        cartItem.setBadgeItem(mCartBadge)

        // 消息
        val msgItem = BottomNavigationItem(R.drawable.btn_nav_msg_press, resources.getString(R.string.nav_bar_message))
            .setInactiveIconResource(R.drawable.btn_nav_msg_normal)
            .setActiveColorResource(R.color.colorPrimary)
            .setInActiveColorResource(R.color.colorPrimaryDark)

        mMsgBadge = ShapeBadgeItem()
        mMsgBadge.setShape(ShapeBadgeItem.SHAPE_OVAL)
        msgItem.setBadgeItem(mMsgBadge)

        // 消息
        val userItem = BottomNavigationItem(R.drawable.btn_nav_user_press, resources.getString(R.string.nav_bar_user))
            .setInactiveIconResource(R.drawable.btn_nav_user_normal)
            .setActiveColorResource(R.color.colorPrimary)
            .setInActiveColorResource(R.color.colorPrimaryDark)

        // 设置导航模式以及样式
        setBackgroundStyle(BACKGROUND_STYLE_STATIC)
        backgroundColor = resources.getColor(R.color.common_white)

        // 添加 Tab
        addItem(homeItem)
            .addItem(categoryItem)
            .addItem(cartItem)
            .addItem(msgItem)
            .addItem(userItem)
            .setMode(MODE_FIXED)
            .setFirstSelectedPosition(0)
            .initialise()
    }

    /**
     * 设置购物车是否 Tab 显示标签
     */
    fun checkCartBadge( count : Int ) {
        if (count == 0) {
            mCartBadge.hide()
        } else {
            mCartBadge.show()
            mCartBadge.setText("$count")
        }
    }

    /**
     * 设置消息是否 Tab 显示标签
     */
    fun checkMsgBadge(isVisible : Boolean) {
        if(isVisible) {
            mMsgBadge.show()
        } else {
            mMsgBadge.hide()
        }
    }
}
