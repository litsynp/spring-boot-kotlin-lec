package com.litsynp.demo.controller.delete

import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class DeleteApiController {

    // 1. path variable
    // 2. request param

    @DeleteMapping("/delete-mapping")
    fun deleteMapping(
        @RequestParam(value = "name") _name: String,
        @RequestParam(value = "age") _age: Int
    ): String {
        println(_name)
        println(_age)
        return "${_name} ${_age}"
    }

    @DeleteMapping("/delete-mapping/name/{name}/age/{age}")
    fun deleteMappingPath(
        @PathVariable("name") _name: String, @PathVariable("age") _age: Int
    ): String {
        println(_name)
        println(_age)
        return "${_name} ${_age}"
    }
}
