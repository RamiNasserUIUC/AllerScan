// Put this at: app/src/main/java/com/example/allerscan/database/ProductDao.kt
package com.example.allerscan.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ProductDao {
    @Query("SELECT * FROM products")
    fun getAllProducts(): List<Product>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProduct(product: Product)

    @Query("SELECT * FROM products WHERE barcode = :code")
    fun findProduct(code: String): Product?
}