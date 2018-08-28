package com.example.trith.baseproject.data.model

import android.arch.persistence.room.Entity

/**
 * Created by tri.th on 27/08/2018.
 */
@Entity(primaryKeys = ["id"])
data class UserModel (val id: Int,
                      val name: String,
                      val phone: String,
                      val avatar: String)