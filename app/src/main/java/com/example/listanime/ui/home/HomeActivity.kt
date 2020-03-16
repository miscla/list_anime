package com.example.listanime.ui.home

import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listanime.R
import com.example.listanime.base.BaseActivity
import com.example.listanime.model.ListTopAnime
import com.example.listanime.model.ModelTopAnime
import kotlinx.android.synthetic.main.activity_base_api.*

class HomeActivity : BaseActivity<ListTopPresenter>(), ListTopView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base_api)

        val type = "anime"
        val page  = "1"
        val subType  = "upcoming"

        rc_list_anime.setHasFixedSize(true)
//        rc_list_anime.layoutManager = LinearLayoutManager(this)
        rc_list_anime.layoutManager = GridLayoutManager(this, 2)

        presenter.onViewCreated()
        presenter.loadListTop(type, page, subType)
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun instantiatePresenter(): ListTopPresenter {
        return ListTopPresenter(this)
    }

    override fun getListTop(data: ModelTopAnime) {
        val listTop : MutableList<ListTopAnime>
        listTop = data.top

        val adapterListTop = ListTopAdapter(listTop)
        adapterListTop.notifyDataSetChanged()

        rc_list_anime.adapter = adapterListTop
    }

    override fun showError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show()
    }

    override fun showLoading() {
    }

    override fun hideLoading() {
    }

}