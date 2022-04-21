package com.kbstar.springboot.study.web.dto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/*
06. Getter가 자동으로 동작하는지 단위테스트
 */
public class HelloResponseDtoTest {
    @Test
    public void lombokTest()
    {
        String name = "test";
        int age = 34;

        HelloResponseDto  dto = new HelloResponseDto(name, age);
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAge()).isEqualTo(age);
    }
}
