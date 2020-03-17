package com.itheima.player.ui.activity

import android.support.v4.view.ViewCompat
import android.support.v4.view.ViewPropertyAnimatorListener
import android.view.View
import com.itheima.player.R
import com.itheima.player.base.BaseActivity
import kotlinx.android.synthetic.main.activity_splash.*


/**
 * ClassName:SplashActivity
 * Description:
 */
class SplashActivity: BaseActivity(), ViewPropertyAnimatorListener {
    override fun onAnimationEnd(view: View?) {
        //进入主界面
//        startActivity<MainActivity>()
//        finish()
        startActivityAndFinish<MainActivity>()

    }

    override fun onAnimationCancel(view: View?) {
    }

    override fun onAnimationStart(view: View?) {
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_splash
    }

    override fun initData() {
        ViewCompat.animate(imageView).scaleX(1.0f).scaleY(1.0f).setListener(this).setDuration(2000)
    }
}