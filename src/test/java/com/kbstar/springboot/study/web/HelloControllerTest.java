package com.kbstar.springboot.study.web;

import com.kbstar.springboot.study.web.HelloController;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

// 03. 아래 import는 처음 한번 직접 타이핑(Alt-Enter)에서 없는 녀석

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers= HelloController.class)
public class HelloControllerTest {


    @Autowired
    private MockMvc mvc;


    @Test
    public void helloReturnTest() throws Exception
    {
        String hello = "hello";

        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));

    }

    @Test
    public void helloDtoTest() throws Exception
    {
        String name = "HongKilDong";
        int age = 78;

        mvc.perform(get("/hello/dto")
                        .param("name", name)
                        .param("age", String.valueOf(age)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.age", is(age)));


    }

}

/*
전체구조는 main쪽의 구조와 같아야 한다.

@ExtendWith , 이전에는 @RunWith
@WebMvcTest
    @Controller
@Autowired 자동주입
    field, constructor, setter

04. Lombok 설치
앞으로 할 일( Lombok  : 생성자, getter/setter를 자동으로 처리)

Ctrl+Shift+A
plugins => Lombok 설치 확인
build.gradle에 추가
 */
