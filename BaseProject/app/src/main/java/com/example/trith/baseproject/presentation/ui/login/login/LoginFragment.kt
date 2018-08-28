package com.example.trith.baseproject.presentation.ui.login.login


import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import android.widget.Toast
import com.example.trith.baseproject.R
import com.example.trith.baseproject.common.ResourceManager
import com.example.trith.baseproject.common.singleClick
import com.example.trith.baseproject.data.local.AppDatabase
import com.example.trith.baseproject.data.local.dao.UserDao
import com.example.trith.baseproject.data.model.UserModel
import com.example.trith.baseproject.domain.entity.User
import com.example.trith.baseproject.errorhandler.CanShowAuthenticationError
import com.example.trith.baseproject.errorhandler.CanShowError
import com.example.trith.baseproject.errorhandler.DemoHandlingAuthenticationError
import com.example.trith.baseproject.presentation.base.BaseFragment
import com.example.trith.baseproject.presentation.ui.login.LoginNavigation
import io.reactivex.observers.DisposableSingleObserver
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.custom.async
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.support.v4.alert
import org.jetbrains.anko.support.v4.onUiThread
import org.jetbrains.anko.support.v4.toast
import org.jetbrains.anko.uiThread
import javax.inject.Inject
import kotlin.concurrent.thread

/**
 * A simple [Fragment] subclass.
 */
class LoginFragment : BaseFragment<LoginViewModel>(), CanShowError,CanShowAuthenticationError {

    @Inject
    lateinit var loginNavigation: LoginNavigation

    @Inject
    lateinit var mErrorHandler: DemoHandlingAuthenticationError

    @Inject
    lateinit var resourceManager: ResourceManager

    @Inject
    lateinit var userDao:UserDao

    override fun getLayoutId(): Int = R.layout.fragment_login

    override fun setViewModel(): LoginViewModel
            = ViewModelProviders.of(this, viewModelFactory).get(LoginViewModel::class.java)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initEvent()
        mErrorHandler.attachView(this)
    }

    private fun initEvent() {
//        btnLogin.singleClick {
//            val userName = etUserName.text.toString()
//            val password = etPassword.text.toString()
//            viewModel.doLogin(userName, password, object : DisposableSingleObserver<User>() {
//                override fun onSuccess(t: User) {
//                    loginNavigation.navigateToMain()
//                }
//
//                override fun onError(e: Throwable) {
//                    mErrorHandler.proceed(e)
//                }
//            })
//        }

        btnLogin.singleClick {
            val userName = etUserName.text.toString()
            val password = etPassword.text.toString()
            val userModel = UserModel(1,userName,"0000000","d")
           doAsync {
               userDao.insert(userModel)
               uiThread {
                   toast("Save user success")
               }
           }
        }
    }

    override fun onLoading() {
        super.onLoading()
        progressBar.visibility = View.VISIBLE
    }

    override fun onStopLoading() {
        super.onStopLoading()
        progressBar.visibility = View.GONE
    }

    override fun showError(error: String) {
        toast(error)
    }

    override fun onDestroy() {
        super.onDestroy()
        mErrorHandler.dettachView()
    }

    override fun showAuthenticationError() {
        val message = resourceManager.getString(R.string.error_unauthorized)
        alert(message,"Error").show()
    }

}// Required empty public constructor
