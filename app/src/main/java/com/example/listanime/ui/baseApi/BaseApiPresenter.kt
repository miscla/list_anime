package com.example.listanime.ui.baseApi

import com.example.listanime.R
import com.example.listanime.base.BasePresenter
import com.example.listanime.network.BaseApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class BaseApiPresenter(baseApiView: BaseApiView) : BasePresenter<BaseApiView>(baseApiView) {
    @Inject
    lateinit var baseApi: BaseApi

    private var subscription: Disposable? = null

    override fun onViewCreated() {
        loadBaseApi()
    }

    fun loadBaseApi() {
        view.showLoading()
        subscription = baseApi
            .getBaseApi()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .doOnTerminate { view.hideLoading() }
            .subscribe(
                { getData -> view.getBaseApi(getData) },
                { view.showError("Error load API") }
            )
    }

    override fun onViewDestroyed() {
        subscription?.dispose()
    }
}