package com.example.trith.baseproject.presentation.ui.main.home


import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.Fragment
import com.example.trith.baseproject.R
import com.example.trith.baseproject.presentation.base.BaseFragment


/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : BaseFragment<HomeViewModel>() {

    override fun getLayoutId(): Int = R.layout.fragment_home

    override fun setViewModel(): HomeViewModel
            = ViewModelProviders.of(this,viewModelFactory).get(HomeViewModel::class.java)



}// Required empty public constructor
