package com.example.final_1.dao

import androidx.room.Dao
import androidx.room.Query

@Dao
interface MyDao {

    @Query("SELECT * FROM Dizim WHERE name LIKE :name")
    fun searchByName(name:String) : List<User>

    @Query("SELECT * FROM Dizim")
    fun getAllUser() : List<User>
}