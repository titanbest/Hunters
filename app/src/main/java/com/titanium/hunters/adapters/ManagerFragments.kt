package com.titanium.hunters.adapters

import android.support.v4.app.Fragment
import com.titanium.hunters.utils.MenuFragments
import com.titanium.hunters.view.fragments.*

class ManagerFragments {
    companion object {
        val mainFragment: Fragment = FragmentFight.fragment

        val fragmentBottomMenuPanel: Fragment = FragmentBottomMenuPanel.fragment

        val fragmentLevelStatus: Fragment = FragmentLevelStatus.fragment

        fun getBottomMenuFragments(position: MenuFragments): Fragment = when (position) {
            MenuFragments.Item -> FragmentHeroItems.fragment
            MenuFragments.Artifact -> FragmentHeroArtefacts.fragment
            MenuFragments.Quest -> FragmentHeroQuests.fragment
            MenuFragments.Inventory -> FragmentHeroInventory.fragment
        }
    }
}