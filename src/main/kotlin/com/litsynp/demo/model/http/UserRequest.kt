package com.litsynp.demo.model.http

// 클래스 단위 지정
// @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class UserRequest(
    var name: String? = null,
    var age: Int? = null,
    var email: String? = null,
    var address: String? = null,

//    @JsonProperty("phone_number") // 프로퍼티 단위 지정
    var phoneNumber: String? = null
)

/*
{
    "name": "litsynp",
    "age": 10,
    "email": "litsynp@example.com",
    "address": "address",
    "phone_number": "010-1111-2222"
}
 */
