package com.itheima.player.util

import com.itheima.player.R
import com.itheima.player.base.BaseFragment
import com.itheima.player.ui.fragment.HomeFragment
import com.itheima.player.ui.fragment.MvFragment
import com.itheima.player.ui.fragment.VBangFragment
import com.itheima.player.ui.fragment.YueDanFragment


/**
 * ClassName:FragmentUtil
 * Description:管理fragment的util类
 */
class FragmentUtil private constructor(){//私有化构造方法
    val homeFragment by lazy { HomeFragment() }
    val mvFragment by lazy { MvFragment() }
    val vbangFragment by lazy { VBangFragment() }
    val yuedanFragment by lazy { YueDanFragment() }
    companion object {
        val fragmentUtil by lazy { FragmentUtil() }
    }

    /**
     * 根据tabid获取对应的fragment
     */
    fun getFragment(tabId:Int):BaseFragment?{
        when(tabId){
            R.id.tab_home->return homeFragment
            R.id.tab_mv->return mvFragment
            R.id.tab_vbang->return vbangFragment
            R.id.tab_yuedan->return yuedanFragment
        }
        return null
    }
}