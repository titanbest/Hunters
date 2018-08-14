package com.titanium.hunters.di.module

import com.titanium.hunters.di.module.viewmodeldi.ViewModelModule
import dagger.Module

@Module(includes = [
    (ApplicationModule::class),
    (ActivityModule::class),
    (FragmentModule::class),
    (ViewModelModule::class)
])
interface CoreModule