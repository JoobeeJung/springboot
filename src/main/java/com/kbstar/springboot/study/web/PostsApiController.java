package com.kbstar.springboot.study.web;

import com.kbstar.springboot.study.service.PostsService;
import com.kbstar.springboot.study.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/*
    20. 작업순서

    Controller -----(DTO)---------> Service 저장 요청 ------> DB


    <form method="post" action="/api/v1/posts">
                        <!-- action="main.php?cmd=board&mode=insert" -->
        <input type="text" name="title">
        <textarea name="content"></textarea>
        <button type="submit">저장</button>
    </form>

    <form method="get" action="/api/v1/posts">
                        <!-- action="main.php?cmd=board&mode=insert" -->
        <input type="text" name="title">
        <textarea name="content"></textarea>
        <button type="submit">저장</button>
    </form>





 */
@RequiredArgsConstructor
@RestController
public class PostsApiController {
    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(PostsSaveRequestDto requestDto)
    {
        System.out.println("-------------- Controller -> Service");
        return postsService.save(requestDto);
    }
}
