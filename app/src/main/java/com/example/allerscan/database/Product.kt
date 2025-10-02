// Put this at: app/src/main/java/com/example/allerscan/database/Product.kt
package com.example.allerscan.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class Product(
    @PrimaryKey val barcode: String,
    val name: String,
    val ingredients: String? = null,
    val dateScanned: String = java.util.Date().toString()
)