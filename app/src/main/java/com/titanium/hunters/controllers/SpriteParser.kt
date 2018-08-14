package com.titanium.hunters.controllers

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.AnimationDrawable
import android.graphics.drawable.BitmapDrawable

import com.titanium.hunters.R
import com.titanium.hunters.utils.Constants

import java.util.Random
import javax.inject.Inject

class SpriteParser @Inject constructor(
        private val context: Context
) {
    private val random = Random()

    private val bitmapUnit = arrayOfNulls<Bitmap>(Constants.UNIT_STATE_COUNT)

    val unitAnimation: AnimationDrawable
        get() {
            val animation = AnimationDrawable()
            animation.isOneShot = true

            when (random.nextInt(7)) {
                0 -> {
                    bitmapUnit[0] = BitmapFactory.decodeResource(context.resources, R.drawable.unit_02)
                    setFlashEffect()
                }
                1 -> {
                    bitmapUnit[0] = BitmapFactory.decodeResource(context.resources, R.drawable.unit_03)
                    setFlashEffect()
                }
                2 -> {
                    bitmapUnit[0] = BitmapFactory.decodeResource(context.resources, R.drawable.unit_04)
                    setFlashEffect()
                }
                3 -> {
                    bitmapUnit[0] = BitmapFactory.decodeResource(context.resources, R.drawable.unit_05)
                    setDarkEffect()
                }
                4 -> {
                    bitmapUnit[0] = BitmapFactory.decodeResource(context.resources, R.drawable.unit_06)
                    setDarkEffect()
                }
                5 -> {
                    bitmapUnit[0] = BitmapFactory.decodeResource(context.resources, R.drawable.unit_07)
                    setDarkEffect()
                }
                6 -> {
                    bitmapUnit[0] = BitmapFactory.decodeResource(context.resources, R.drawable.unit_10)
                    setDarkEffect()
                }
                7 -> {
                    bitmapUnit[0] = BitmapFactory.decodeResource(context.resources, R.drawable.unit_11)
                    setDarkEffect()
                }

                else -> {
                    bitmapUnit[0] = BitmapFactory.decodeResource(context.resources, R.drawable.unit_02)
                    setFlashEffect()
                }
            }


            for (i in 0 until Constants.UNIT_STATE_COUNT) {
                animation.addFrame(BitmapDrawable(context.resources, bitmapUnit[i]), Constants.FRAME_DURATION)
            }
            return animation
        }

    val goldAnimation: AnimationDrawable
        get() {
            val animation = AnimationDrawable()
            animation.isOneShot = false
            val bitmapGold = arrayOfNulls<Bitmap>(Constants.GOLD_STATE_COUNT)

            bitmapGold[0] = BitmapFactory.decodeResource(context.resources, R.drawable.gold_01)
            bitmapGold[1] = BitmapFactory.decodeResource(context.resources, R.drawable.gold_02)
            bitmapGold[2] = BitmapFactory.decodeResource(context.resources, R.drawable.gold_03)
            bitmapGold[3] = BitmapFactory.decodeResource(context.resources, R.drawable.gold_04)

            for (i in 0 until Constants.GOLD_STATE_COUNT) {
                animation.addFrame(BitmapDrawable(context.resources, bitmapGold[i]), 80)
            }
            return animation
        }

    private fun setFlashEffect() {
        bitmapUnit[1] = BitmapFactory.decodeResource(context.resources, R.drawable.effect_1)
        bitmapUnit[2] = BitmapFactory.decodeResource(context.resources, R.drawable.effect_2)
        bitmapUnit[3] = BitmapFactory.decodeResource(context.resources, R.drawable.effect_3)
        bitmapUnit[4] = BitmapFactory.decodeResource(context.resources, R.drawable.effect_4)
        bitmapUnit[5] = BitmapFactory.decodeResource(context.resources, R.drawable.effect_5)
        bitmapUnit[6] = BitmapFactory.decodeResource(context.resources, R.drawable.effect_6)
    }

    private fun setDarkEffect() {
        bitmapUnit[1] = BitmapFactory.decodeResource(context.resources, R.drawable.darck_effect_1)
        bitmapUnit[2] = BitmapFactory.decodeResource(context.resources, R.drawable.darck_effect_2)
        bitmapUnit[3] = BitmapFactory.decodeResource(context.resources, R.drawable.darck_effect_3)
        bitmapUnit[4] = BitmapFactory.decodeResource(context.resources, R.drawable.darck_effect_4)
        bitmapUnit[5] = BitmapFactory.decodeResource(context.resources, R.drawable.darck_effect_5)
        bitmapUnit[6] = BitmapFactory.decodeResource(context.resources, R.drawable.darck_effect_6)
    }
}
