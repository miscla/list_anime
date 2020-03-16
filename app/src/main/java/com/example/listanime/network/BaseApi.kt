package com.example.listanime.network

import com.example.listanime.model.ModelBaseAPI
import io.reactivex.Observable
import retrofit2.http.GET

interface BaseApi {
    @GET(".")
    fun getBaseApi(): Observable<ModelBaseAPI>
}