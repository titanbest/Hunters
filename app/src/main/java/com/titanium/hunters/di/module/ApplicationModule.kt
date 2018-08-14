package com.titanium.hunters.di.module

import android.arch.persistence.room.Room
import android.content.Context
import android.content.SharedPreferences
import com.titanium.hunters.AppHunters
import com.example.hunters.di.annotation.PerApplication
import com.titanium.data.db.AppDatabase
import com.titanium.hunters.controllers.SpriteParser
import com.titanium.hunters.utils.Constants
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule {

    @Provides
    @PerApplication
    fun provideApplicationContext(application: AppHunters): Context = application

    @Provides
    @PerApplication
    fun provideSharedPreferences(context: Context): SharedPreferences =
            context.getSharedPreferences(Constants.SHARED_PREF_NAME, Context.MODE_PRIVATE)

//    @Provides
//    @PerApplication
//    fun provideSettingsRepository(storage: SettingsStorage): SettingsRepository = storage

    @Provides
    @PerApplication
    fun provideAppDatabase(context: Context): AppDatabase = Room
            .databaseBuilder(context, AppDatabase::class.java, Constants.DATA_BASE_NAME)
            .build()
}