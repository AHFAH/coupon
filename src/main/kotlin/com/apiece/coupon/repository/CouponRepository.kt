package com.apiece.coupon.repository

import com.apiece.coupon.domain.Coupon
import org.springframework.data.jpa.repository.JpaRepository

interface CouponRepository : JpaRepository<Coupon, Long> {

}