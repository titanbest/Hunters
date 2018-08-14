package com.titanium.hunters.view.custom

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.RelativeLayout
import com.titanium.hunters.R
import kotlinx.android.synthetic.main.hp_lvl_gold_view.view.*

class HpLvlGoldView : RelativeLayout {
    internal var layout: RelativeLayout? = null

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {

        val array = context.obtainStyledAttributes(attrs, R.styleable.HpLvlGoldView)

        var lvl = array.getString(R.styleable.HpLvlGoldView_lvl)
        var nextLvl = array.getString(R.styleable.HpLvlGoldView_nextLvl)
        var hp = array.getString(R.styleable.HpLvlGoldView_hp)
        var gold = array.getString(R.styleable.HpLvlGoldView_gold)
        var name = array.getString(R.styleable.HpLvlGoldView_name)
        val lineHp = array.getInt(R.styleable.HpLvlGoldView_hpLine, 0)
        val lineHpMax = array.getInt(R.styleable.HpLvlGoldView_hpLineMax, 0)
        val subLevel = array.getInt(R.styleable.HpLvlGoldView_subLevel, 1)

        lvl = if (lvl == null) "" else lvl
        nextLvl = if (nextLvl == null) "" else nextLvl
        hp = if (hp == null) "" else hp
        name = if (name == null) "" else name
        gold = if (gold == null) "" else gold

        val service = Context.LAYOUT_INFLATER_SERVICE
        val inflater = getContext().getSystemService(service) as LayoutInflater

        layout = inflater.inflate(R.layout.hp_lvl_gold_view, this, true) as RelativeLayout

        layout!!.textLvl.text = lvl
        layout!!.textNextLvl.text = nextLvl
        layout!!.textHp.text = hp
        layout!!.textGold.text = gold
        layout!!.textName.text = name
        layout!!.hpLine.max = lineHpMax
        layout!!.hpLine.progress = lineHp

        setPagerLevel(subLevel)

        array.recycle()
    }

    private fun setPagerLevel(i: Int) {
        setDefaultLevels()
        when (i) {
            1 -> layout!!.lvl_1.isChecked = true
            2 -> layout!!.lvl_2.isChecked = true
            3 -> layout!!.lvl_3.isChecked = true
            4 -> layout!!.lvl_4.isChecked = true
            5 -> layout!!.lvl_5.isChecked = true
            6 -> layout!!.lvl_6.isChecked = true
            7 -> layout!!.lvl_7.isChecked = true
            8 -> layout!!.lvl_8.isChecked = true
            9 -> layout!!.lvl_9.isChecked = true
            10 -> layout!!.lvl_10.isChecked = true
            else -> layout!!.lvl_1.isChecked = true
        }
    }

    private fun setDefaultLevels() {
        layout!!.lvl_1.isChecked = false
        layout!!.lvl_2.isChecked = false
        layout!!.lvl_3.isChecked = false
        layout!!.lvl_4.isChecked = false
        layout!!.lvl_5.isChecked = false
        layout!!.lvl_6.isChecked = false
        layout!!.lvl_7.isChecked = false
        layout!!.lvl_8.isChecked = false
        layout!!.lvl_9.isChecked = false
        layout!!.lvl_10.isChecked = false
    }

    fun setSubLevel(i: Int) = setPagerLevel(i)

    fun setLvl(text: String) {
        layout!!.textLvl.text = text
    }

    fun setNextLvl(text: String) {
        layout!!.textNextLvl.text = text
    }

    fun setHp(text: String) {
        layout!!.textHp.text = text
    }

    fun setGold(text: String) {
        layout!!.textGold.text = text
    }

    fun setName(name: String) {
        layout!!.textName.text = name
    }

    fun setHpLineMax(max: Int) {
        layout!!.hpLine.max = max
    }

    fun setHpLine(hp: Int) {
        layout!!.hpLine.progress = hp
    }
}