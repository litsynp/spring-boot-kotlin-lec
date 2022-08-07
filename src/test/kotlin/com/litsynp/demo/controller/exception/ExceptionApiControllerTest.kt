package com.litsynp.demo.controller.exception

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.litsynp.demo.model.http.UserRequest
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import org.springframework.util.LinkedMultiValueMap

@WebMvcTest
@AutoConfigureMockMvc
class ExceptionApiControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun helloTest() {
        mockMvc.perform(
            get("/api/exception/hello")
        ).andExpect(
            status().isOk
        ).andExpect(
            content().string("hello")
        ).andDo(print())
    }

    @Test
    fun getTest() {
        val queryParams = LinkedMultiValueMap<String, String>().apply {
            add("name", "litsy")
            add("age", "20")
        }

        mockMvc.perform(
            get("/api/exception")
                .queryParams(queryParams)
        ).andExpect(
            status().isOk
        ).andExpect(
            content().string("litsy 20")
        ).andDo(print())
    }

    @Test
    fun getFailTest() {
        val queryParams = LinkedMultiValueMap<String, String>().apply {
            add("name", "litsy")
            add("age", "9")
        }

        mockMvc.perform(
            get("/api/exception")
                .queryParams(queryParams)
        ).andExpect(
            status().isBadRequest
        ).andExpect(
            content().contentType(MediaType.APPLICATION_JSON)
        ).andExpect(
            jsonPath("$.result_code").value("FAIL")
        ).andExpect(
            jsonPath("$.errors[0].field").value("age")
        ).andExpect(
            jsonPath("$.errors[0].value").value("9")
        ).andDo(print())
    }

    @Test
    fun postTest() {
        val userRequest = UserRequest().apply {
            name = "litsynp"
            age = 10
            phoneNumber = "010-1111-2222"
            address = "경기도 성남시"
            email = "litsynp@example.com"
            createdAt = "2022-08-07 13:00:00"
        }

        val json = jacksonObjectMapper().writeValueAsString(userRequest)

        mockMvc.perform(
            post("/api/exception")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
        ).andExpect(
            status().isOk
        ).andExpect(
            jsonPath("\$.name").value("litsynp")
        ).andExpect(
            jsonPath("\$.age").value("10")
        ).andExpect(
            jsonPath("\$.email").value("litsynp@example.com")
        ).andDo(print())
    }

    @Test
    fun postFailTest() {
        val userRequest = UserRequest().apply {
            name = "litsynp"
            age = -1
            phoneNumber = "010-1111-2222"
            address = "경기도 성남시"
            email = "litsynp@example.com"
            createdAt = "2022-08-07 13:00:00"
        }

        val json = jacksonObjectMapper().writeValueAsString(userRequest)

        mockMvc.perform(
            post("/api/exception")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
        ).andExpect(
            status().isBadRequest
        ).andDo(print())
    }
}
