package com.heyabhi.textviewverticalreveal.extensions

import android.view.View

fun View.updateHeight(newHeight: Int) {
    layoutParams = layoutParams.apply {
        height = newHeight
    }
}
