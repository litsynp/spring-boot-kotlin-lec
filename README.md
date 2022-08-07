# \[Inflearn\] Kotlin으로 개발하는 Spring Boot Web MVC

\[Inflearn\] Kotlin으로 개발하는 Spring Boot Web MVC 강의 내용에 따른 예제를 진행한다.

## Versions

- Spring Boot 2.7.2

- JDK 8

- Kotlin 1.6.21

- Gradle 7.5

## Contents

Kotlin을 이용해 Spring Boot로 간단한 API를 구현해본다.

- GET, POST, PUT, DELETE mappings

  - [`com.litsynp.demo.controller`](https://github.com/litsynp/spring-boot-kotlin-lec/tree/main/src/main/kotlin/com/litsynp/demo/controller)

- Bean validations with `spring-boot-starter-validation`

  - [`com.litsynp.demo.model.http.UserRequest`](https://github.com/litsynp/spring-boot-kotlin-lec/blob/main/src/main/kotlin/com/litsynp/demo/model/http/UserRequest.kt)

- Custom LocalDateTime validation annotator for DTO

  - [`com.litsynp.demo.annotation.StringFormatDateTime`](https://github.com/litsynp/spring-boot-kotlin-lec/blob/main/src/main/kotlin/com/litsynp/demo/annotation/StringFormatDateTime.kt)
  - [`com.litsynp.demo.validator.StringFormatDateTimeValidator`](https://github.com/litsynp/spring-boot-kotlin-lec/blob/main/src/main/kotlin/com/litsynp/demo/validator/StringFormatDateTimeValidator.kt)

- Global and class-level exception handler using `@RestControllerAdvice` with custom error response DTO

  - [`com.litsynp.demo.advice.GlobalControllerAdvice`](https://github.com/litsynp/spring-boot-kotlin-lec/blob/main/src/main/kotlin/com/litsynp/demo/advice/GlobalControllerAdvice.kt)
  - [`com.litsynp.demo.controller.exception.ExceptionApiController`](https://github.com/litsynp/spring-boot-kotlin-lec/blob/main/src/main/kotlin/com/litsynp/demo/controller/exception/ExceptionApiController.kt)

- Unit tests with MockMvc
  - [`com.litsynp.demo.controller.exception.ExceptionApiControllerTest`](https://github.com/litsynp/spring-boot-kotlin-lec/blob/main/src/test/kotlin/com/litsynp/demo/controller/exception/ExceptionApiControllerTest.kt)

## REF

[Inflearn: Kotlin으로 개발하는 Spring Boot Web MVC](https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81%EB%B6%80%ED%8A%B8-%EC%BD%94%ED%8B%80%EB%A6%B0)
