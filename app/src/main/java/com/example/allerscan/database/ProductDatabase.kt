// Put this at: app/src/main/java/com/example/allerscan/database/ProductDatabase.kt
package com.example.allerscan.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Product::class], version = 1)
abstract class ProductDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao

    // This is a simple singleton pattern
    companion object {
        private var instance: ProductDatabase? = null

        fun getDatabase(context: Context): ProductDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    ProductDatabase::class.java,
                    "product_database"
                ).build()
            }
            return instance!!
        }
    }
}