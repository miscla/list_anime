package com.example.listanime.base

import com.example.listanime.injection.ContextModule
import com.example.listanime.injection.NetworkModule
import com.example.listanime.injection.component.DaggerPresenterInjector
import com.example.listanime.injection.component.PresenterInjector
import com.example.listanime.ui.baseApi.BaseApiPresenter
import com.example.listanime.ui.home.ListTopPresenter

abstract class BasePresenter<out V : BaseView>(protected val view: V) {

    /**
     * The inhector used to inject required dependencies
     */
    private val injector: PresenterInjector = DaggerPresenterInjector
        .builder()
        .baseView(view)
        .contextModule(ContextModule)
        .networkModule(NetworkModule)
        .build()

    init {
        inject()
    }

    /**
     * This method may be called when the presenter view is created
     */
    open fun onViewCreated(){}

    /**
     * This method may be called when the presenter view is destroyed
     */
    open fun onViewDestroyed(){}

    /**
     * Injects the required dependencies
     */
    private fun inject() {
        when (this) {
            is BaseApiPresenter -> injector.injectBaseApi(this)
            is ListTopPresenter -> injector.injectListTop(this)
        }
    }
}