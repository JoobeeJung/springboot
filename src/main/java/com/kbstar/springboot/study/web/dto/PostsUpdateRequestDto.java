package com.kbstar.springboot.study.web.dto;

/*
22. Post Update

    개발 순서 :
        1. DTO
        2. Service
        3. Controller
 */

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsUpdateRequestDto {
    private String title;
    private String content;

    @Builder
    public PostsUpdateRequestDto(String title, String content)
    {
        this.title = title;
        this.content = content;
    }
}
