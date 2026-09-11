package com.apiece.coupon.controller

import com.apiece.coupon.controller.dto.request.CreateCouponRequest
import com.apiece.coupon.controller.dto.response.CouponResponse
import com.apiece.coupon.controller.dto.response.IssuanceResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RestController

@RestController
class CouponController {


    @PostMapping
    fun create(@RequestBody request: CreateCouponRequest): ResponseEntity<CouponResponse> {

    }

    @PostMapping("/{couponId}/issue")
    fun issue(
        @PathVariable couponId: Long,
        @RequestHeader("X-User-Id") userId: Long,
        ): IssuanceResponse {

        }
}