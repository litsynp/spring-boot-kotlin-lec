package com.litsynp.demo.model.http

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.validation.constraints.AssertTrue
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Pattern
import javax.validation.constraints.PositiveOrZero
import javax.validation.constraints.Size

// 클래스 단위 지정
// @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class UserRequest(
    @field:NotEmpty
    @field:Size(min = 2, max = 8)
    var name: String? = null,

    @field:PositiveOrZero
    var age: Int? = null,

    @field:Email
    var email: String? = null,

    @field:NotBlank
    var address: String? = null,

    @field:Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}\$")
//    @JsonProperty("phone_number") // 프로퍼티 단위 지정
    var phoneNumber: String? = null,

    var createdAt: String? = null, // yyyy-MM-dd HH:mm:ss  ex) 2020-10-02 13:00:00
) {

    @AssertTrue(message = "생성일자의 패턴은 yyyy-MM-dd HH:mm:ss 여야 합니다")
    private fun isValidCreatedAt(): Boolean {  // 정상 true, 비정상 false
        return try {
            LocalDateTime.parse(this.createdAt, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
            true
        } catch (e: Exception) {
            false
        }
    }
}
/*
{
    "name": "litsynp",
    "age": 10,
    "email": "litsynp@example.com",
    "address": "address",
    "phone_number": "010-1111-2222"
}
 */
