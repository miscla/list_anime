package com.example.listanime.ui.baseApi

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.listanime.R
import com.example.listanime.base.BaseActivity
import com.example.listanime.model.ModelBaseAPI
import kotlinx.android.synthetic.main.activity_base_api.*

class BaseApiActivity : BaseActivity<BaseApiPresenter>(), BaseApiView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base_api)

        presenter.onViewCreated()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onViewDestroyed()
    }

    override fun instantiatePresenter(): BaseApiPresenter {
        return BaseApiPresenter(this)
    }

    override fun getBaseApi(data: ModelBaseAPI) {

//        tv_hello_world.setText("Author : " + data.Author + "\n" + "Version : " + data.Version + "\n" +
//                "Website : " + data.Website + "\n" + "Documents : " + data.Docs + "\n" + "Github : " + data.GitHub)
    }

    override fun showError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show()
    }

    override fun showLoading() {
    }

    override fun hideLoading() {
    }
}
