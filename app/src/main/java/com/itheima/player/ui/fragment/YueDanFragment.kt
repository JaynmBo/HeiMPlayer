package com.itheima.player.ui.fragment

import com.itheima.player.adapter.YueDanAdapter
import com.itheima.player.base.BaseListAdapter
import com.itheima.player.base.BaseListFragment
import com.itheima.player.base.BaseListPresenter
import com.itheima.player.model.bean.YueDanBean
import com.itheima.player.presenter.impl.YueDanPresenterImpl
import com.itheima.player.widget.YueDanItemView


/**
 * ClassName:HomeFragment
 * Description:悦单界面
 */
class YueDanFragment: BaseListFragment<YueDanBean, YueDanBean.PlayListsBean, YueDanItemView>() {
    override fun getSpecialAdapter(): BaseListAdapter<YueDanBean.PlayListsBean, YueDanItemView> {
        return YueDanAdapter()
    }

    override fun getSpecialPresenter(): BaseListPresenter {
        return YueDanPresenterImpl(this)
    }

    override fun getList(response: YueDanBean?): List<YueDanBean.PlayListsBean>? {
        return response?.playLists
    }

}