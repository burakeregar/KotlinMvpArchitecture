package com.burakeregar.kotlinmvparchitecture.home.viewholder

import android.view.View
import com.burakeregar.kotlinmvparchitecture.home.model.MarsItem
import com.burakeregar.easiestgenericrecycleradapter.base.GenericViewHolder
import kotlinx.android.synthetic.main.row_mars.view.*
import org.greenrobot.eventbus.EventBus

/**
 * Created by Burak Eregar on 23.05.2017.
 * burakeregar@gmail.com
 * https://github.com/burakeregar
 */
class MarsViewHolder(itemView: View?) : GenericViewHolder<Any>(itemView) {
    lateinit var item: MarsItem

    override fun bindData(p0: Any?) {
        item = p0 as MarsItem
        with(itemView) {
            row_imageview?.setImageURI(item.image)
            row_date?.text = item.date
            rowMarsRoot.setOnClickListener {
                EventBus.getDefault().post(item)
            }
        }
    }
}