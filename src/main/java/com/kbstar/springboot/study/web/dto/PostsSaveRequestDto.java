package com.kbstar.springboot.study.web.dto;

import com.kbstar.springboot.study.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/*
    18. 게시글 저장을 위한 데이터 덩어리 만들기
         id, title, content, author
         insert into posts (title, content, author) values (?, ?, ?);

Web layer에서 데이터를 받아서 repository에 저장하기 위해서 DTO로 받을 데이터를 정의하고
Service layer 통해서 저장. 데이터가 변하면 Domain model 쪽만 변경됨

         +-----------------------+   +-----------+
         |    Web Layer          |   |           |
         |   (controllers) (3)   |   |    DTO(1) |
         +-----------------------+   |           |
         +-----------------------+   |           |
         |    Service Layer(2)   |   +-----------+
         |                       |   +-----------+
         +-----------------------+   |  Domain   |
         +-----------------------+   |  Model    |
         |    Repository Layer   |   | (Entity)  |
         |                       |   |  Posts    |
         +-----------------------+   +-----------+
 */
@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String author;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author)
    {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity()
    {
        return Posts.builder().title(title).content(content).author(author).build();
    }
}
