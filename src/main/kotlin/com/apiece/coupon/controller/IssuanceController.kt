package com.apiece.coupon.controller

import com.apiece.coupon.controller.dto.response.IssuanceResponse
import com.apiece.coupon.domain.Issuance
import com.apiece.coupon.service.IssuanceService
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/issuances/")
class IssuanceController(
    private val IssuanceService: IssuanceService,
) {

    @PostMapping("/{issuanceId}/use")
    fun use(
        @PathVariable issuanceId: Long,
        @RequestHeader("X-User-Id") userId: Long,
    ): IssuanceResponse {
        val issuance = IssuanceService.use(issuanceId, userId)
        return IssuanceResponse.from(issuance)
    }
}