package com.ngnhng.demo.order.adapter.`in`.restful.api.v1

import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.validation.method.MethodValidationException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice(basePackageClasses = [OrderController::class])
class ExceptionHandler {

    @ExceptionHandler(MethodValidationException::class)
    fun handleMethodValidationException(e: MethodValidationException) {
        // handle exception
    }

    @ExceptionHandler(HttpMessageNotReadableException::class)
    fun handleHttpMessageNotReadableException(e: HttpMessageNotReadableException): ResponseEntity<Void> {
        // handle exception
        return ResponseEntity.badRequest().build()
    }
}