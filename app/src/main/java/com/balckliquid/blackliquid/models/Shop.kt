package com.balckliquid.blackliquid.models

import java.time.LocalDateTime
import java.util.UUID

data class Shop(
    val name:String,
    val location:String,
    val products:Product
)
data class Util(
    val product_name: String,
    val product_id:String = UUID.randomUUID().toString()
)

data class Product(
    val name:String,
    val id:String,
    val description:String? = null,
    val purchase_price: Double,
    val date_of_purchase: java.util.Date,
    val quantity: Int

)
data class Sale(
    val product: Product,
    val unit_price:  Double,
    val quantity: Double,
    val sale_date: LocalDateTime,
    val payment_method: String
)

data class Bill(
    val bill_name:String,
    val description: String?= null,
    val amount: Double,
    val date_paid: Double

)
data class Cashout(
    val amount: Double,
    val reason:String,
    val person_name: String,
    val date_paid: Double
)
data class CashIn(
    val amount: Double,
    val reason:String,
    val person_name: String,
    val date_paid: Double
)
data class Loss(
    val product: Product,
    val loss_description:String,
    val unit_price: Double,
    val quantity: Double,
    val date_paid: Double
)
