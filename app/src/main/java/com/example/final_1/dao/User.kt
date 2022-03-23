package com.example.final_1.dao

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Dizim")
data class User (
    @PrimaryKey
    var id : Int,
    var name : String,
    var salary: Int,
    var work: String
        )