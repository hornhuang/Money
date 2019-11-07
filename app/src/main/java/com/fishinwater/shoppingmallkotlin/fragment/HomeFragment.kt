package com.fishinwater.shoppingmallkotlin.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.fishinwater.shoppingmallkotlin.R
import com.fishinwater.shoppingmallkotlin.widgets.BannerImageLoader
import com.youth.banner.BannerConfig
import com.youth.banner.Transformer
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.view_flipper.*

class HomeFragment : Fragment() {

    private val BANNER_FIRST  = "https://img-blog.csdnimg.cn/20191029235433160.png"
    private val BANNER_SECOND = "https://img-blog.csdnimg.cn/20191106111343298.png"
    private val BANNER_THIRD  = "https://img-blog.csdnimg.cn/20191107100322247.png"
    private val BANNER_FORTH  = "https://img-blog.csdnimg.cn/2019110710183499.png"


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_home, null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        iniBanner()
        iniViewFlipper()
    }

    private fun iniBanner() {
        mHomeBanner.run {
            setImageLoader(BannerImageLoader())
            // 图片资源
            setImages(listOf(BANNER_FIRST, BANNER_SECOND, BANNER_THIRD, BANNER_FORTH))
            setBannerAnimation(Transformer.Accordion)
            setDelayTime(3000)
            // 设置指示器位置（ 当 Banner 有指示器时 ）
            setIndicatorGravity(BannerConfig.RIGHT)
            // Banner 所有方法调用完后调用
            start()
        }
    }

    private fun iniViewFlipper() {
        mViewFlipper.isAutoStart = true
        mViewFlipper.setFlipInterval(3000)
        mViewFlipper.startFlipping()
    }

    override fun onStop() {
        mViewFlipper.stopFlipping()
        super.onStop()
    }

    override fun onResume() {
        if (mViewFlipper != null)
            mViewFlipper.startFlipping()
        super.onResume()
    }

}
