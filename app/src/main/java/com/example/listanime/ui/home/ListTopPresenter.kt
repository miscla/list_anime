package com.example.listanime.ui.home

import com.example.listanime.base.BasePresenter
import com.example.listanime.network.TopApi
import com.example.listanime.ui.baseApi.BaseApiView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ListTopPresenter(listTopView: ListTopView) : BasePresenter<ListTopView>(listTopView)  {
    @Inject
    lateinit var topApi: TopApi

    private var subscription: Disposable? = null

    var type: String = ""
    var page: String = ""
    var subType: String = ""

    override fun onViewCreated() {
        loadListTop(type, page, subType)
    }

    fun loadListTop(type: String, page: String, subType: String) {
        view.showLoading()
        subscription = topApi
            .getTopAnimeApi(type, page, subType)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .doOnTerminate { view.hideLoading() }
            .subscribe(
                { getData -> view.getListTop(getData) },
                { view.showError("Error load API") }
            )
    }

    override fun onViewDestroyed() {
        subscription?.dispose()
    }
}