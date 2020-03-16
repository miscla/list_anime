package com.example.listanime.ui.home

import androidx.annotation.StringRes
import com.example.listanime.base.BaseView
import com.example.listanime.model.ModelBaseAPI
import com.example.listanime.model.ModelTopAnime

interface ListTopView : BaseView {
    /**
     * Updates the previous posts by the specified ones
     * @param posts the list of posts that will replace existing ones
     */
    fun getListTop(data: ModelTopAnime)

    /**
     * Displays an error in the view
     * @param error the error to display in the view
     */
    fun showError(error: String)

    /**
     * Displays an error in the view
     * @param errorResId the resource id of the error to display in the view
     */
    fun showError(@StringRes errorResId: Int){
        this.showError(getContext().getString(errorResId))
    }

    /**
     * Displays the loading indicator of the view
     */
    fun showLoading()

    /**
     * Hides the loading indicator of the view
     */
    fun hideLoading()
}