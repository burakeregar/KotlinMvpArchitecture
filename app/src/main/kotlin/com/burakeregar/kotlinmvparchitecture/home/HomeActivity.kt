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
import org.greenrobot.eventbus.Subscribe
import org.jetbrains.anko.toast
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
        adapter = GenericAdapterBuilder().addModel(
                R.layout.row_mars,
                MarsViewHolder::class.java,
                MarsItem::class.java)
                .execute()
        home_rv.layoutManager = LinearLayoutManager(this)
        home_rv.adapter = adapter
    }

    override fun onActivityInject() {
        DaggerHomeActivityComponent.builder().appComponent(getAppcomponent())
                .homeActivityModule(HomeActivityModule())
                .build()
                .inject(this)

        presenter.attachView(this)
    }

    override fun addPhotos(photos: MarsPhotos) {
        adapter.setList(photos.photoList)
    }

    @Subscribe
    fun onRowClicked(item: MarsItem){
        toast("Image Url: ${item.image}")
    }
}
