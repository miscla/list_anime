package com.example.listanime.model

data class ModelTopAnime(val top: MutableList<ListTopAnime>)

data class ListTopAnime(val mal_id: Int?, val rank: Int?, val title: String?,
                        val url: String?, val image_url: String?, val type: String?,
                        val episodes: String?, val start_date: String?, val end_date: String?,
                        val members: Int?, val score: String?)