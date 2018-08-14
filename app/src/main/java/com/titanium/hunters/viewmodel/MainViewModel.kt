package com.titanium.hunters.viewmodel

import com.titanium.hunters.adapters.ManagerFragments
import com.titanium.hunters.utils.MenuFragments
import com.titanium.hunters.view.activities.MainActivity
import com.titanium.hunters.R
import javax.inject.Inject

class MainViewModel @Inject constructor() : BaseViewModel() {

    fun initMainFragment(context: MainActivity) = context.supportFragmentManager
            .beginTransaction()
            .replace(R.id.containerMain, ManagerFragments.mainFragment)
            .commit()

    fun initFragmentLevelStatus(context: MainActivity) = context.supportFragmentManager
            .beginTransaction()
            .replace(R.id.containerLevel, ManagerFragments.fragmentLevelStatus)
            .commit()

    fun initFragmentBottomMenuPanel(context: MainActivity) = context.supportFragmentManager
            .beginTransaction()
            .replace(R.id.menuPanel, ManagerFragments.fragmentBottomMenuPanel)
            .commit()

    fun setToBottomMenuContainer(context: MainActivity, position: MenuFragments) {
        context.supportFragmentManager
                .beginTransaction()
                .replace(R.id.containerAttributePanel, ManagerFragments.getBottomMenuFragments(position))
                .commit()
    }
}