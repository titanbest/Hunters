package com.titanium.hunters.di.module

import com.example.hunters.di.annotation.PerFragment
import com.titanium.hunters.view.fragments.*
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface FragmentModule {

    @ContributesAndroidInjector
    @PerFragment
    fun fragmentFight() : FragmentFight

    @ContributesAndroidInjector
    @PerFragment
    fun fragmentBottomMenuPanel() : FragmentBottomMenuPanel

    @ContributesAndroidInjector
    @PerFragment
    fun fragmentLevelStatus() : FragmentLevelStatus

    @ContributesAndroidInjector
    @PerFragment
    fun fragmentHeroArtefacts() : FragmentHeroArtefacts

    @ContributesAndroidInjector
    @PerFragment
    fun fragmentHeroInventory() : FragmentHeroInventory

    @ContributesAndroidInjector
    @PerFragment
    fun fragmentHeroItems() : FragmentHeroItems

    @ContributesAndroidInjector
    @PerFragment
    fun fragmentHeroQuests() : FragmentHeroQuests
}