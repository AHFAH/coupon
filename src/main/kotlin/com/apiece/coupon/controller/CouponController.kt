package com.apiece.coupon.controller

import com.apiece.coupon.controller.dto.request.CreateCouponRequest
import com.apiece.coupon.controller.dto.response.CouponResponse
import com.apiece.coupon.controller.dto.response.IssuanceResponse
import com.apiece.coupon.service.CouponService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RestController

@RestController
class CouponController(
    private val couponService: CouponService,
) {


    @PostMapping
    fun create(@RequestBody request: CreateCouponRequest): ResponseEntity<CouponResponse> {
        val coupon = couponService.createCoupon(request)
        return ResponseEntity.status(HttpStatus.CREATED).body(CouponResponse.from(coupon))
    }

    @PostMapping("/{couponId}/issue")
    fun issue(
        @PathVariable couponId: Long,
        @RequestHeader("X-User-Id") userId: Long,
        ): IssuanceResponse {
        val issuance = couponService.issue(couponId, userId)
        return IssuanceResponse.from(issuance)
        }
}