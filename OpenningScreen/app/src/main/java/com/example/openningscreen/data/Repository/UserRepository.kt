package com.example.openningscreen.data.Repository

import com.example.openningscreen.data.DAO.UserDao
import com.example.openningscreen.data.Entity.UserEntity

class UserRepository(private val userDao: UserDao) {
    suspend fun login(email: String, password: String): Boolean {
        return userDao.login(email, password) != null
    }

    suspend fun insertUser(userEntity: UserEntity) {
        return userDao.insertUser(userEntity)
    }
}