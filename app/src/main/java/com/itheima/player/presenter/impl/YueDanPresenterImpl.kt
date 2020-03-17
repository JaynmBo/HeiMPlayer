package com.itheima.player.presenter.impl

import com.itheima.player.base.BaseListPresenter
import com.itheima.player.base.BaseView
import com.itheima.player.model.bean.YueDanBean
import com.itheima.player.net.ResponseHandler
import com.itheima.player.net.YueDanRequest
import com.itheima.player.presenter.interf.YueDanPresenter


/**
 * ClassName:YueDanPresenterImpl
 * Description:
 */
class YueDanPresenterImpl(var yueDanView:BaseView<YueDanBean>?):YueDanPresenter, ResponseHandler<YueDanBean> {
    override fun destoryView() {
        if(yueDanView!=null){
            yueDanView=null
        }
    }

    override fun onError(type: Int, msg: String?) {
        yueDanView?.onError(msg)
    }

    override fun onSuccess(type: Int, result: YueDanBean) {
        if(type==BaseListPresenter.TYPE_INIT_OR_REFRESH){
            yueDanView?.loadSuccess(result)
        }else if(type==BaseListPresenter.TYPE_LOAD_MORE){
            yueDanView?.loadMore(result)
        }
    }

    override fun loadDatas() {
        YueDanRequest(BaseListPresenter.TYPE_INIT_OR_REFRESH,0,this).excute()
    }

    override fun loadMore(offset: Int) {
        YueDanRequest(BaseListPresenter.TYPE_LOAD_MORE,offset,this).excute()
    }

}