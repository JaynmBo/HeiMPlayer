package com.itheima.player.net

import com.itheima.player.model.bean.YueDanBean
import com.itheima.player.util.URLProviderUtils


/**
 * ClassName:YueDanRequest
 * Description:悦单界面网络请求request
 */
class YueDanRequest(type:Int,offset:Int,handler:ResponseHandler<YueDanBean>)
    : MRequest<YueDanBean>(type,URLProviderUtils.getYueDanUrl(offset,20),handler) {
}