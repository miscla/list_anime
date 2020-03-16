package com.example.listanime.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.listanime.R
import com.example.listanime.model.ListTopAnime
import com.example.listanime.model.ModelTopAnime
import com.example.listanime.network.TopApi
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.rc_list_anime.view.*

class ListTopAdapter(private val list : MutableList<ListTopAnime>) :RecyclerView.Adapter<ListTopAdapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(LayoutInflater.from(parent.context).inflate(R.layout.rc_list_anime,parent,false))
    }

    override fun getItemCount(): Int = list?.size

    override fun onBindViewHolder(holder: Holder, position: Int) {

        holder.view.tv_title_anime.text = list?.get(position)?.title

        val picasso = Picasso.get()
        picasso.load(list?.get(position).image_url).resize(100, 100).into(holder.view.image_title_anime)

    }

    class Holder(val view: View) : RecyclerView.ViewHolder(view)

}