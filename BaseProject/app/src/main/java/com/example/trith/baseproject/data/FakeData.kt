package com.example.trith.baseproject.data

import com.example.trith.baseproject.data.model.UserModel

/**
 * Created by tri.th on 27/08/2018.
 */
class FakeData {
    companion object {
        val userList = arrayListOf<UserModel>(
                UserModel(1,"John","11111111111","avatar1"),
                UserModel(2,"Mary","222222222222","avatar1"),
                UserModel(3,"Matt","333333333","avatar1"),
                UserModel(4,"Elly","14444444","avatar1"),
                UserModel(5,"Ken","111111444","avatar1"),
                UserModel(6,"ABC","3333333","avatar1"),
                UserModel(7,"John2","11111144444411","avatar1"),
                UserModel(8,"John3","5555555","avatar1")
        )
    }
}