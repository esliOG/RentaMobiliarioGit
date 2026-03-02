package com.tuempresa.rentaapp.models

data class RentalOrder(
    val id: String = "",
    val userId: String = "",
    val items: List<CartItem> = emptyList(),
    val deliveryDate: Long = 0L,
    val returnDate: Long = 0L,
    val status: OrderStatus = OrderStatus.PENDING,
    val paymentStatus: PaymentStatus = PaymentStatus.PENDING,
    val totalCost: Double = 0.0,
    val paymentMethod: String = ""
)

data class CartItem(
    val furnitureId: String = "",
    val quantity: Int = 0,
    val pricePerItem: Double = 0.0
)

enum class OrderStatus {
    PENDING,
    APPROVED,
    IN_PROGRESS,
    RETURNED,
    CANCELLED
}

enum class PaymentStatus {
    PENDING,
    PAID,
    REFUNDED
}
