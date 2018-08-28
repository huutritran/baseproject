package com.example.trith.baseproject.domain

/**
 * Created by tri.th on 27/08/2018.
 */
class AccountValidator {
    fun isValid(userNam:String,password:String):Boolean{
        return userNam.isNotEmpty() && password.isNotEmpty()
    }
}