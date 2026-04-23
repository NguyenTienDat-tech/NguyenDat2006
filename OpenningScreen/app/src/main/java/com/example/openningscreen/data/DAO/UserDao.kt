package com.example.openningscreen.data.DAO

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.openningscreen.data.Entity.UserEntity

@Dao
interface UserDao {
    @Insert
    suspend fun insertUser(user: UserEntity)

    @Query("SELECT * FROM users WHERE email = :email AND password = :password LIMIT 1")
    suspend fun login(email: String, password: String): UserEntity?

    @Query("SELECT * FROM users WHERE email = :email LIMIT 1")
    suspend fun checkEmail(email: String): UserEntity?
}