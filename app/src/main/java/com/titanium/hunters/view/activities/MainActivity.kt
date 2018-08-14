package com.titanium.hunters.view.activities

import android.os.Bundle
import android.view.View
import com.titanium.hunters.callbacks.IFragmentPosition
import com.titanium.hunters.extantions.viewModel
import com.titanium.hunters.utils.MenuFragments
import com.titanium.hunters.R
import com.titanium.hunters.view.base.BaseActivity
import com.titanium.hunters.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(R.layout.activity_main), IFragmentPosition {
    private var position: MenuFragments? = null
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = viewModel(viewModelFactory) {
            initMainFragment(this@MainActivity)
            initFragmentLevelStatus(this@MainActivity)
            initFragmentBottomMenuPanel(this@MainActivity)
        }
    }

    override fun setBottomMenuFragment(position: MenuFragments) {
        if (this.position == position) {
            containerAttributePanel.visibility = View.GONE
            this.position = null
        } else {
            containerAttributePanel.visibility = View.VISIBLE
            this.position = position
            viewModel.setToBottomMenuContainer(this, this.position!!)
        }
    }
}