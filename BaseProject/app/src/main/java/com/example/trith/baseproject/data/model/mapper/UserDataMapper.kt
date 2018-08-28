package com.example.trith.baseproject.data.model.mapper

import com.example.trith.baseproject.common.Mapper
import com.example.trith.baseproject.data.model.UserModel
import com.example.trith.baseproject.domain.entity.User

/**
 * Created by tri.th on 27/08/2018.
 */
class UserDataMapper : Mapper<UserModel, User>() {

    override fun map(from: UserModel): User {
        return User(id = from.id,
                name = from.name,
                phone = from.phone,
                avatar = from.avatar)
    }

    override fun reverseMap(to: User): UserModel {
        return UserModel(id = to.id,
                name = to.name,
                phone = to.phone,
                avatar = to.avatar)
    }
}