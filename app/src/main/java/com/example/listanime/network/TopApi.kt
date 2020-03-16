package com.example.listanime.network

import com.example.listanime.model.ModelTopAnime
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface TopApi {
    @GET("top/{type}/{page}/{subType}")
    fun getTopAnimeApi(@Path("type") type: String, @Path("page") page: String, @Path("subType") subType: String): Observable<ModelTopAnime>
}