package com.dynatrace.vast.playground

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class HelloController {

    @GetMapping("/hello")
    @ResponseBody
    fun sayHello(@RequestParam(defaultValue = "World") name: String): String {
        return "Hello, $name!"
    }
}
