package com.example.listanime.injection.component

import com.example.listanime.base.BaseView
import com.example.listanime.injection.ContextModule
import com.example.listanime.injection.NetworkModule
import com.example.listanime.ui.baseApi.BaseApiPresenter
import com.example.listanime.ui.home.ListTopPresenter
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(ContextModule::class), (NetworkModule::class)])
interface PresenterInjector {
    /**
     * Injects required dependencies into the specified PostPresenter.
     * @param baseApiPresenter PostPresenter in which to inject the dependencies
     */
    fun injectBaseApi(baseApiPresenter: BaseApiPresenter)
    fun injectListTop(listTopPresenter: ListTopPresenter)

    @Component.Builder
    interface Builder {
        fun build(): PresenterInjector

        fun networkModule(networkModule: NetworkModule): Builder
        fun contextModule(contextModule: ContextModule): Builder

        @BindsInstance
        fun baseView(baseView: BaseView): Builder
    }
}