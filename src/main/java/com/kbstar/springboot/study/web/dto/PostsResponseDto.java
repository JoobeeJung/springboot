package com.kbstar.springboot.study.web.dto;

import com.kbstar.springboot.study.domain.posts.Posts;
import lombok.Getter;

import java.time.LocalDateTime;

/*
    23.. Request에 대한 응답 데이터 만들기

          1
                 Dto(4)
          2
                Entity(5)
          3

          5를 이용해 4번을 만들기
 */

@Getter
public class PostsResponseDto {
    private Long id;
    private String title;
    private String content;
    private String author;
    private int view;
    private int rec;
    // 41. DTO에 추가하기

    public PostsResponseDto(Posts entity)
    {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
        this.view = entity.getView();
        this.rec = entity.getRec();
    }
}
