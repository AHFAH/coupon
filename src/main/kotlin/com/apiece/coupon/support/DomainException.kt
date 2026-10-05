package com.apiece.coupon.support

import org.springframework.http.HttpStatus

sealed class DomainException(
    val code: String,
    val httpStatus: HttpStatus,
    message: String,
) : RuntimeException(message)

class CouponNotFoundException(message: String = "쿠폰 정보를 찾을 수 없습니다.") :
    DomainException("COUPON_NOT_FOUND", HttpStatus.NOT_FOUND, message)

class NotStartedException(message: String = "발급이 아직 시작되지 않았습니다.") :
    DomainException("NOT_STARTED", HttpStatus.SERVICE_UNAVAILABLE, message)

class SoldOutException(message: String = "쿠폰이 매진되었습니다.") :
    DomainException("SOLD_OUT", HttpStatus.BAD_REQUEST, message)

class AlreadyIssuedException(message : String = "이미 쿠폰이 발급되었습니다.") :
    DomainException("ALREADY_ISSUED", HttpStatus.BAD_REQUEST, message)

class IssuanceNotFoundException(message: String = "발급 내역을 찾을 수 없습니다.") :
    DomainException("ISSUANCE_NOT_FOUND", HttpStatus.BAD_REQUEST, message)

class NotOwnerException(message: String = "본인의 쿠폰이 아닙니다") :
    DomainException("NOT_OWNER", HttpStatus.FORBIDDEN, message)

class AlreadyUsedException(message: String = "이미 사용된 쿠폰입니다.") :
    DomainException("ALREADY_USED", HttpStatus.BAD_REQUEST, message)

class ExpiredException(message: String = "유효기간이 만료된 쿠폰입니다.") :
    DomainException("EXPIRED", HttpStatus.BAD_REQUEST, message)