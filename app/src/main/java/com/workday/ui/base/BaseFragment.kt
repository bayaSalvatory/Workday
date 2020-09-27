package com.workday.ui.base

import android.os.Bundle
import com.airbnb.mvrx.BaseMvRxFragment

abstract class BaseFragment : BaseMvRxFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}