package com.titanium.hunters.view.fragments

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.titanium.hunters.view.base.BaseFragment
import com.titanium.hunters.R
import com.titanium.hunters.callbacks.IFragmentPosition
import com.titanium.hunters.utils.MenuFragments
import kotlinx.android.synthetic.main.fragment_bottom_menu.*

class FragmentBottomMenuPanel : BaseFragment(R.layout.fragment_bottom_menu) {

    private lateinit var fragmentPosition: IFragmentPosition
    private lateinit var openAnimation: Animation
    private lateinit var closeAnimation: Animation
    private val delayTime : Long = 500

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        openAnimation = AnimationUtils.loadAnimation(activity, R.anim.open_bottom_menu)
        closeAnimation = AnimationUtils.loadAnimation(activity, R.anim.close_bottom_menu)

        buttonMenuItems.setOnClickListener { setFragmentPosition(MenuFragments.Item) }
        buttonMenuArtifact.setOnClickListener { setFragmentPosition(MenuFragments.Artifact) }
        buttonMenuQuest.setOnClickListener { setFragmentPosition(MenuFragments.Quest) }
        buttonMenuInventory.setOnClickListener { setFragmentPosition(MenuFragments.Inventory) }
        buttonCloseMenu.setOnClickListener { visibleMenu(false) }
        buttonHideMenu.setOnClickListener { visibleMenu(true) }
    }

    private fun visibleMenu(isVisible: Boolean) {
        if (isVisible) {
            layoutClosedMenu.postDelayed({ layoutClosedMenu.visibility = View.VISIBLE }, delayTime)
            layoutOpenedMenu.startAnimation(closeAnimation)
            layoutOpenedMenu.postDelayed({ layoutOpenedMenu.visibility = View.GONE }, delayTime)
        } else {
            layoutClosedMenu.visibility = View.GONE
            layoutOpenedMenu.visibility = View.VISIBLE
            layoutOpenedMenu.startAnimation(openAnimation)
        }
    }

    private fun setFragmentPosition(position: MenuFragments) = fragmentPosition.setBottomMenuFragment(position)

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        fragmentPosition = context as IFragmentPosition
    }

    companion object {
        val fragment: FragmentBottomMenuPanel
            get() = FragmentBottomMenuPanel()
    }
}