package com.burakeregar.kotlinmvparchitecture.home.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Burak Eregar on 23.05.2017.
 * burakeregar@gmail.com
 * https://github.com/burakeregar
 */

data class MarsItem(@SerializedName("img_src") var image: String, @SerializedName("earth_date") var date: String)