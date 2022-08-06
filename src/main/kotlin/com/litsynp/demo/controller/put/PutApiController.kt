package com.litsynp.demo.controller.put

import com.litsynp.demo.model.http.UserRequest
import com.litsynp.demo.model.http.UserResponse
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class PutApiController {

    @PutMapping("/put-mapping")
    fun putMapping(): String {
        return "put-mapping"
    }

    @RequestMapping(method = [RequestMethod.PUT], path = ["/request-mapping"])
    fun requestMapping(): String {
        return "request-mapping"
    }

    @PutMapping("/put-mapping/object")
    fun putMapping(@RequestBody userRequest: UserRequest): UserResponse {
        // 0. response
        return UserResponse().apply {
            // 1. result
            this.result = com.litsynp.demo.model.http.Result().apply {
                this.resultCode = "OK"
                this.resultMessage = "성공"
            }
        }.apply {
            // 2. description
            this.description = "~~~~~~~~"
        }.apply {
            // 3. user mutable list
            val userList = mutableListOf<UserRequest>()
            userList.add(userRequest)
            userList.add(UserRequest().apply {
                this.name = "a"
                this.age = 10
                this.email = "a@gmail.com"
                this.address = "a address"
                this.phoneNumber = "010-1111-2222"
            })
            userList.add(UserRequest().apply {
                this.name = "b"
                this.age = 20
                this.email = "b@gmail.com"
                this.address = "b address"
                this.phoneNumber = "010-1111-3333"
            })
            this.userResponse = userList
        }
    }
}

/*
{
    "result": { // snake_case
        "result_code": "OK",
        "result_message": "성공"
    }
    "description": "...",
    "user": [ // 배열
        {
            "name": "",
            "age": 10,
            "email": "litsynp@example.com",
            "phoneNumber": "" // 여기는 camelCase
        },
        {
            "name": "",
            "age": 10,
            "email": "litsynp@example.com",
            "phoneNumber": ""
        },
        {
            "name": "",
            "age": 10,
            "email": "litsynp@example.com",
            "phoneNumber": ""
        }
    ]
}
 */
