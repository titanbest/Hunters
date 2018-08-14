package com.titanium.hunters.di.module.viewmodeldi

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.titanium.hunters.view.activities.MainActivity
import com.titanium.hunters.viewmodel.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindsMainViewModel(mainViewModel: MainViewModel): ViewModel


}