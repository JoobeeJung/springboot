package com.kbstar.springboot.study.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;


/*
05

DTO : Data Transfer Object


@Getter : field의 get method를 자동으로 생성
@RequreiredArgsConstructor
    선언된 field가 포함된 생성자 자동 생성
    private String name;
    private int age;
    public HelloResponseDto(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public String getName()
    {
        return this.name;
    }

    public int getAge()
    {
        return this.age;
    }

    Lombok에 getter가 자동으로 생성..==> 확인
    단위테스트로 확인 ==> main, test구조가 같다.

 */
@Getter
@RequiredArgsConstructor
public class HelloResponseDto {
    private final String name;
    private final int age;
}
