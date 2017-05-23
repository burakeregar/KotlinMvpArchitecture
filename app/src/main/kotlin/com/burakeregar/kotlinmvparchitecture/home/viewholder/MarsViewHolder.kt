package com.burakeregar.kotlinmvparchitecture.home.viewholder

import android.view.View
import com.burakeregar.kotlinmvparchitecture.home.model.MarsItem
import com.burakeregar.easiestgenericrecycleradapter.base.GenericViewHolder
import kotlinx.android.synthetic.main.row_mars.view.*

/**
 * Created by Burak Eregar on 23.05.2017.
 * burakeregar@gmail.com
 * https://github.com/burakeregar
 */
class MarsViewHolder(itemView: View?) : GenericViewHolder<Any>(itemView) {
    lateinit var item: MarsItem

    override fun bindData(p0: Any?) {
        item = p0 as MarsItem
        itemView.row_imageview?.setImageURI(item.image)
        itemView.row_date?.setText(item.date)
    }
}