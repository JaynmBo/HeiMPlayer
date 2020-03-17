package com.itheima.player.net

import com.itheima.player.model.bean.MvPagerBean
import com.itheima.player.util.URLProviderUtils


/**
 * ClassName:MvListRequest
 * Description:mv每一个界面数据网络请求
 */
class MvListRequest(type: Int, code:String,offset:Int, handler: ResponseHandler<MvPagerBean>)
    : MRequest<MvPagerBean>(type, URLProviderUtils.getMVListUrl(code,offset,20), handler) {
}