package com.itheima.player.presenter.impl

import com.itheima.player.base.BaseListPresenter
import com.itheima.player.model.bean.MvPagerBean
import com.itheima.player.net.MvListRequest
import com.itheima.player.net.ResponseHandler
import com.itheima.player.presenter.interf.MvListPresenter
import com.itheima.player.view.MvListView


/**
 * ClassName:MvListPresenterImpl
 * Description:
 */
class MvListPresenterImpl(var code:String, var mvListView:MvListView?):MvListPresenter, ResponseHandler<MvPagerBean> {
    override fun onError(type: Int, msg: String?) {
        mvListView?.onError(msg)
    }

    override fun onSuccess(type: Int, result: MvPagerBean) {
        if(type==BaseListPresenter.TYPE_INIT_OR_REFRESH){
            mvListView?.loadSuccess(result)
        }else if(type==BaseListPresenter.TYPE_LOAD_MORE){
            mvListView?.loadMore(result)
        }
    }

    override fun loadDatas() {
        MvListRequest(BaseListPresenter.TYPE_INIT_OR_REFRESH,code,0,this).excute()
    }

    override fun loadMore(offset: Int) {
        MvListRequest(BaseListPresenter.TYPE_LOAD_MORE,code,offset,this).excute()
    }

    override fun destoryView() {
        if(mvListView!=null){
            mvListView=null
        }
    }
}