package com.itheima.player.ui.fragment

import com.itheima.player.adapter.MvListAdapter
import com.itheima.player.base.BaseListAdapter
import com.itheima.player.base.BaseListFragment
import com.itheima.player.base.BaseListPresenter
import com.itheima.player.model.VideoPlayBean
import com.itheima.player.model.bean.MvPagerBean
import com.itheima.player.model.bean.VideosBean
import com.itheima.player.presenter.impl.MvListPresenterImpl
import com.itheima.player.ui.activity.JiecaoVideoPlayerActivity
import com.itheima.player.view.MvListView
import com.itheima.player.widget.MvItemView
import org.jetbrains.anko.support.v4.startActivity


/**
 * ClassName:MvPagerFragment
 * Description:mv界面每一个页面fragment
 */
class MvPagerFragment: BaseListFragment<MvPagerBean, VideosBean, MvItemView>(), MvListView {
    var code:String? = null
    override fun init() {
        code = arguments.getString("args")
    }
    override fun getSpecialAdapter(): BaseListAdapter<VideosBean, MvItemView> {
        return MvListAdapter()
    }

    override fun getSpecialPresenter(): BaseListPresenter {
        return MvListPresenterImpl(code!!,this)
    }

    override fun getList(response: MvPagerBean?): List<VideosBean>? {
        return response?.videos
    }

    override fun initListener() {
        super.initListener()
        //设置条目点击事件监听函数
        adapter.setMyListener{
            val videoPlayBean = VideoPlayBean(it.id,it.title,it.url)
            //跳转到视频播放界面
            startActivity<JiecaoVideoPlayerActivity>("item" to videoPlayBean)
        }
    }
}