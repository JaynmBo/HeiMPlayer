package com.itheima.player.ui.activity

import com.itheima.player.R
import com.itheima.player.base.BaseActivity
import com.itheima.player.model.VideoPlayBean
import io.vov.vitamio.LibsChecker
import kotlinx.android.synthetic.main.activity_video_player_vitamio.*


/**
 * ClassName:VideoPlayerActivity
 * Description:
 */
class VitamioVideoPlayerActivity: BaseActivity() {
    override fun getLayoutId(): Int {
        return R.layout.activity_video_player_vitamio
    }

    override fun initData() {
        //初始化vitamio
        LibsChecker.checkVitamioLibs(this)
        //获取传递的数据
        val videoPlayBean = intent.getParcelableExtra<VideoPlayBean>("item")
        videoView.setVideoPath(videoPlayBean.url)//异步准备
//        videoView.start()
        videoView.setOnPreparedListener {
            videoView.start()
        }
    }
}