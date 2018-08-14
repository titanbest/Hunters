package com.titanium.hunters.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.titanium.hunters.utils.IDisposable

abstract class BaseViewModel : ViewModel() {

    open val loading = MutableLiveData<Boolean>()

    val error = MutableLiveData<String>()

    override fun onCleared() {
        super.onCleared()
        javaClass.declaredFields
                .filter { IDisposable::class.java.isAssignableFrom(it.type) }
                .forEach {
                    try {
                        it.isAccessible = true
                        (it.get(this) as IDisposable).dispose()
                    } catch (e: IllegalAccessException) {
                        Log.e("BaseViewModel", "Can't dispose ", e)
                    }
                }
    }
}