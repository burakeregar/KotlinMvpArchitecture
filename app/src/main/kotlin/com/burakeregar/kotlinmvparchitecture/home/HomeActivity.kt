package com.burakeregar.kotlinmvparchitecture.home

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.base.BaseActivity
import com.burakeregar.kotlinmvparchitecture.R
import com.burakeregar.kotlinmvparchitecture.home.di.DaggerHomeActivityComponent
import com.burakeregar.kotlinmvparchitecture.home.di.HomeActivityModule
import com.burakeregar.kotlinmvparchitecture.home.model.MarsPhotos
import com.burakeregar.kotlinmvparchitecture.home.model.MarsItem
import com.burakeregar.kotlinmvparchitecture.home.presenter.HomePresenter
import com.burakeregar.kotlinmvparchitecture.home.presenter.HomeView
import com.burakeregar.kotlinmvparchitecture.home.viewholder.MarsViewHolder
import com.burakeregar.easiestgenericrecycleradapter.base.GenericAdapterBuilder
import com.burakeregar.easiestgenericrecycleradapter.base.GenericRecyclerAdapter
import kotlinx.android.synthetic.main.home_activity.*
import javax.inject.Inject

class HomeActivity : BaseActivity(), HomeView {

    @Inject
    lateinit var presenter: HomePresenter

    lateinit var adapter: GenericRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)

        initAdapter()
        presenter.getMarsPhotos()
    }

    private fun initAdapter() {
        home_rv.setLayoutManager(LinearLayoutManager(this))
        adapter = GenericAdapterBuilder().addModel(
                R.layout.row_mars,
                MarsViewHolder::class.java,
                MarsItem::class.java)
                .execute()
        home_rv.setAdapter(adapter)
    }

    override fun onActivityInject() {
        DaggerHomeActivityComponent.builder().appComponent(getAppcomponent())
                .homeActivityModule(HomeActivityModule(this))
                .build()
                .inject(this)

        presenter.attachView(this)
    }

    override fun addPhotos(photos: MarsPhotos) {
        adapter.setList(photos.photoList)
    }
}
