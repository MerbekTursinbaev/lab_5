package com.example.final_1.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1)
abstract class MyDataBase : RoomDatabase() {

    companion object {
        lateinit var INSTANCE: MyDataBase
        fun getInstance(context: Context): MyDataBase {
            if (!::INSTANCE.isInitialized) {
                INSTANCE = Room.databaseBuilder(
                    context,
                    MyDataBase::class.java, "dizim-database"
                )
                    .createFromAsset("Dizim.db")
                    .allowMainThreadQueries()
                    .build()
            }
            return INSTANCE
        }
    }

    abstract fun myDao(): MyDao
}