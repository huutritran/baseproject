package com.example.trith.baseproject.presentation.base

import android.arch.lifecycle.ViewModelProvider
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.trith.baseproject.di.Injectable
import javax.inject.Inject

/**
 * Created by tri.th on 23/08/2018.
 */
abstract class BaseFragment<VM : BaseViewModel> : Fragment(), Injectable {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    protected lateinit var viewModel: VM

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayoutId(), container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = setViewModel()
        viewModel.getIsLoading().subscribe {
            if (it) onLoading() else onStopLoading()
        }
    }

    abstract fun getLayoutId(): Int

    abstract fun setViewModel(): VM

    open fun onLoading(){}

    open fun onStopLoading(){}

}