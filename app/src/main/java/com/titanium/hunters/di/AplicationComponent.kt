package com.titanium.hunters.di

import com.titanium.hunters.AppHunters
import com.titanium.hunters.di.module.CoreModule
import com.example.hunters.di.annotation.PerApplication
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@PerApplication
@Component(modules = [(CoreModule::class), (AndroidSupportInjectionModule::class)])
interface ApplicationComponent : AndroidInjector<AppHunters> {

    @Component.Builder abstract class Builder : AndroidInjector.Builder<AppHunters>()
}