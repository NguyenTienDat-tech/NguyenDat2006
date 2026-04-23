package com.example.openningscreen.data.Database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.openningscreen.data.DAO.UserDao
import com.example.openningscreen.data.Entity.UserEntity

@Database(entities = [UserEntity::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao
}