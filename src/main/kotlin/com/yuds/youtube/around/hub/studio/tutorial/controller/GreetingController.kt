package com.yuds.youtube.around.hub.studio.tutorial.controller

import com.yuds.youtube.around.hub.studio.tutorial.DTO.UserDTO
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/v1/get")
class GreetingController {

//    @RequestMapping(value = [("/")], method = [RequestMethod.GET])
//    fun greeting(): String {
//        return "getMethod, Good to see you"
//    }


    @GetMapping("/userNm/{userNm}")
    fun greeting(@PathVariable userNm: String): String {
        return "getMethod, Good to see you! userNm: $userNm"
    }

    //변수명 변경해야할 경우
    @GetMapping("/userName/{userNm}")
    // 변수명 변경하기 위해서 사용
    fun greeting1(@PathVariable("userNm") userName: String): String {
        return "getMethod, Good to see you! userName: $userName"
    }

    //    Url 쿼리
    @GetMapping("/userNm")
    fun greeting2(@RequestParam name: String, @RequestParam email: String): String {
        return "getMethod, Good to see you! userName: \"$name\" :: email : \"$email\""
    }

    //    Map 형식으로 받음
    @GetMapping("/map")
    fun greeting3(@RequestParam param: Map<String, String>): String {

        val sb = StringBuilder()

        param.entries.forEach { map ->
            sb.append("${map.key} = ${map.value}, ")
        }
        return "getMethod, Good to see you! userName: \"$sb\""
    }


    // DTO 사용
    @GetMapping("/dto")
    fun greeting4(user: UserDTO): String {
        return "getMethod, Good to see you! userName: \"${user.name}\" :: email : \"${user.email}\""
    }


//    @RequestMapping(value = ["/"], method = [RequestMethod.POST])
//    fun greetingUser(): String {
//        return "postMethod, Good to see you"
//    }

    @PostMapping("/")
    fun greetingUser(): String {
        return "postMethod, Good to see you"
    }


}