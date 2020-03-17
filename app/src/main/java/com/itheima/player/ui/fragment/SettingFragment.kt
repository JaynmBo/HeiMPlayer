package com.itheima.player.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.preference.Preference
import android.preference.PreferenceFragment
import android.preference.PreferenceScreen
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.itheima.player.R
import com.itheima.player.ui.activity.AboutActivity
import org.jetbrains.anko.toast


/**
 * ClassName:SettingFragment
 * Description:
 */
class SettingFragment: PreferenceFragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        addPreferencesFromResource(R.xml.setting)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onPreferenceTreeClick(preferenceScreen: PreferenceScreen?, preference: Preference?): Boolean {
        val key = preference?.key
        if("about".equals(key)){
            //点击了关于
            activity.startActivity(Intent(activity,AboutActivity::class.java))
        }else if("clear_cache".equals(key)){
            toast("清除缓存")
        }
        return super.onPreferenceTreeClick(preferenceScreen, preference)
    }
}