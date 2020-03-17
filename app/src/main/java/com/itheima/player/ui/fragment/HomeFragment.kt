package com.itheima.player.ui.fragment

import com.itheima.player.adapter.HomeAdapter
import com.itheima.player.base.BaseListAdapter
import com.itheima.player.base.BaseListFragment
import com.itheima.player.base.BaseListPresenter
import com.itheima.player.model.bean.HomeItemBean
import com.itheima.player.presenter.impl.HomePresenterImpl
import com.itheima.player.widget.HomeItemView


/**
 * ClassName:HomeFragment
 * Description:
 */
class HomeFragment : BaseListFragment<List<HomeItemBean>, HomeItemBean, HomeItemView>() {
    override fun getSpecialAdapter(): BaseListAdapter<HomeItemBean, HomeItemView> {
        return HomeAdapter()
    }

    override fun getSpecialPresenter(): BaseListPresenter {
        return HomePresenterImpl(this)
    }

    override fun getList(response: List<HomeItemBean>?): List<HomeItemBean>? {
        return response
    }

    override fun onDestroyView() {
        super.onDestroyView()
        //解绑presenter
        presenter.destoryView()
    }
}