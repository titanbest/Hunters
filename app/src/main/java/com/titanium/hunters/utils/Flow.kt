package com.titanium.hunters.utils

import android.content.Context
import com.titanium.data.executor.JobExecutor
import com.titanium.domain.mapper.OutputMapper
import com.titanium.hunters.exception.ErrorMessageFactory
import com.titanium.domain.interactor.UseCase
import com.titanium.hunters.viewmodel.BaseViewModel
import io.reactivex.Single
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

open class MappedFlow<
        in TParamsType,
        TReturnType,
        out TUiModel,
        TMapper : OutputMapper<TReturnType, TUiModel>,
        TUseCase : UseCase<TReturnType, TParamsType>
        > @Inject constructor() : IDisposable {

    @Inject lateinit var useCase: TUseCase
    @Inject lateinit var mapper: TMapper
    @Inject lateinit var context: Context
    @Inject lateinit var uiThread: UIThread
    @Inject lateinit var executor: JobExecutor
    private var viewModel: BaseViewModel? = null
    private var callback: ((result: TUiModel) -> Unit)? = null

    fun run(params: TParamsType, viewModel: BaseViewModel? = null, callback: ((result: TUiModel) -> Unit)? = null) {
        this.viewModel = viewModel
        this.callback = callback

        this@MappedFlow.viewModel?.loading?.value = true
        useCase.execute(object : DisposableObserver<TReturnType>() {

            override fun onNext(t: TReturnType) {
                Single.fromCallable {
                    mapper.transformFromDomain(t)
                }.subscribeOn(Schedulers.from(executor))
                        .observeOn(uiThread.scheduler)
                        .subscribe { it: TUiModel ->
                            this@MappedFlow.callback?.invoke(it)
                            this@MappedFlow.viewModel?.loading?.value = false
                        }
            }

            override fun onComplete() {
                this@MappedFlow.viewModel?.error?.value = null
            }

            override fun onError(e: Throwable) {
                this@MappedFlow.viewModel?.loading?.value = false
                this@MappedFlow.viewModel?.error?.value = ErrorMessageFactory.create(context, e)
            }
        }, params)
    }

    override fun dispose() {
        useCase.dispose()
        viewModel = null
        callback = null
    }

    override fun clear() {
        useCase.clear()
    }
}

class Flow<in TParamsType, TReturnType, TUseCase : UseCase<TReturnType, TParamsType>>
@Inject constructor() : MappedFlow<TParamsType, TReturnType, TReturnType, FakeMapper<TReturnType>, TUseCase>()

class FakeMapper<Item>
@Inject constructor() : OutputMapper<Item, Item> {

    override fun transformFromDomain(item: Item): Item {
        return item
    }
}