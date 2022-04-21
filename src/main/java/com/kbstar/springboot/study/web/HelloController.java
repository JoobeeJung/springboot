package com.kbstar.springboot.study.web;

import com.kbstar.springboot.study.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


// REST vs. 이전 http://localhost/main.php?cmd=test&idx=3
// http://localhost/hello
// JSON(JavaScript Onbject Notation)를 매핑해준다.
// Method의 종류 : GET, POST, PUT, DELETE
/*
    HTTP Error Code
    1xx : Trying
    2xx : OK
    3xx : Temporary Error, Redirection Error
    4xx : Permanent Error, Client Error
        403 : Forbidden
        404 : Not Found
        405 : Method Not Allowed
    5xx : Server Error
    6xx : Global Error

    스프링 부트 : POST(insert), PUT(update)을 구분
    cf. DELETE (삭제)
 */

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello()
    {
        return "hello";
    }

    /* 08. http://localhost:8080/hello/dto?name=홍길동&age=12
            http://localhost:8080/hello/dto/?name=홍길동&age=12
     */

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name,
                                     @RequestParam("age") int age)
    {
        return new HelloResponseDto(name, age);
    }
}
