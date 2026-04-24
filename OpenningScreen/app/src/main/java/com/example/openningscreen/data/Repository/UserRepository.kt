package com.example.openningscreen.data.repository

import com.example.openningscreen.data.local.dao.UserDao
import com.example.openningscreen.data.local.entity.UserEntity

class UserRepository(private val userDao: UserDao) {
    suspend fun login(email: String, password: String): Boolean {
        return userDao.login(email, password) != null
    }

    suspend fun insertUser(userEntity: UserEntity) {
        return userDao.insertUser(userEntity)
    }

    suspend fun email(userEntity: UserEntity): Boolean {
        val check = userDao.checkEmail(userEntity.email)

        return if (check == null) {
            true
        }
        else {
            false
        }
    }

    suspend fun checkEmail(email: String): Boolean {
        return userDao.checkEmail(email) != null
    }

    suspend fun updatePassword(email: String, password: String) {
        return userDao.updatePassword(email, password)
    }


}