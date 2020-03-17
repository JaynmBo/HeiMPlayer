package com.itheima.player.presenter.impl

import com.itheima.player.model.bean.MvAreaBean
import com.itheima.player.net.MvAreaRequest
import com.itheima.player.net.ResponseHandler
import com.itheima.player.presenter.interf.MvPresenter
import com.itheima.player.view.MvView


/**
 * ClassName:MvPresenterImpl
 * Description:
 */
class MvPresenterImpl(var mvView:MvView):MvPresenter, ResponseHandler<List<MvAreaBean>> {
    override fun onError(type: Int, msg: String?) {
        mvView.onError(msg)
    }

    override fun onSuccess(type: Int, result: List<MvAreaBean>) {
        mvView.onSuccess(result)
    }

    /**
     * 加载区域数据
     */
    override fun loadDatas() {
        MvAreaRequest(this).excute()
    }
}