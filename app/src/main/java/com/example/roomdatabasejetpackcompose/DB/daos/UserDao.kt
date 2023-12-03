package com.example.roomdatabasejetpackcompose.DB.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.roomdatabasejetpackcompose.DB.entities.User

@Dao
interface UserDao {
    @Query("SELECT * FROM users")
    fun getAllUsers(): List<User>

    @Query("SELECT * FROM users WHERE id = :userId")
    fun getUserById(userId: Int): User?

    @Insert
    fun insertUser(user: User)

    @Query("DELETE FROM users WHERE id = :userId")
    fun deleteUserById(userId: Int)

    @Query("DELETE FROM users")
    fun deleteAllUsers()
}