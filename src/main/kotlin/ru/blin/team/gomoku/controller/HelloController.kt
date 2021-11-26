package ru.blin.team.gomoku.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import ru.blin.team.gomoku.entity.ResponseMessage

@RestController
class HelloController {
    @RequestMapping(
        method = [RequestMethod.GET],
        value = ["/hello"]
    )
    fun sayHello(
        @RequestParam name: String
    ) = ResponseMessage("Hello, $name")
}