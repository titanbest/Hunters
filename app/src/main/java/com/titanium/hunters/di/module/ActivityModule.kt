@file:Suppress("unused")

package com.titanium.hunters.di.module

import com.titanium.hunters.view.activities.MainActivity
import com.titanium.hunters.view.activities.SplashScreenActivity
import com.example.hunters.di.annotation.PerActivity
import com.titanium.hunters.di.module.FragmentModule
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Module(includes = [(AndroidSupportInjectionModule::class), (FragmentModule::class)])
interface ActivityModule {

    @ContributesAndroidInjector
    @PerActivity
    fun splashScreenActivity(): SplashScreenActivity

    @ContributesAndroidInjector
    @PerActivity
    fun mainActivity(): MainActivity
}