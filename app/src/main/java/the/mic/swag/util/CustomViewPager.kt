package com.android.dutchman.util

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.viewpager.widget.ViewPager


class CustomViewPager : ViewPager {
    constructor(context: Context) : super(context)

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

    override fun onTouchEvent(ev: MotionEvent): Boolean {
        return if (currentItem == 0 && childCount == 0) {
            false
        } else super.onTouchEvent(ev)

    }

    override fun onInterceptTouchEvent(ev: MotionEvent): Boolean {
        return if (currentItem == 0 && childCount == 0) {
            false
        } else super.onInterceptTouchEvent(ev)

    }
}