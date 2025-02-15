package com.ngnhng.demo.notification

interface NotificationInternalAPI {
    fun sendNotification(orderId: String, message: String)
}
