package com.kbstar.springboot.study.web;

import com.kbstar.springboot.study.service.PostsService;
import com.kbstar.springboot.study.web.dto.PostsResponseDto;
import com.kbstar.springboot.study.web.dto.PostsSaveRequestDto;
import com.kbstar.springboot.study.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
    public Long save(@RequestBody PostsSaveRequestDto requestDto)
    {
        System.out.println("-------------- Controller -> Service");
        System.out.println("requestDto.title = " + requestDto.getTitle());
        return postsService.save(requestDto);
    }

    /*
    26 수정을 위한 REST 등록
    Method : POST, PUT(0), GET, DELETE

    DTO -> Service -> Controller -> 단위테스트
     */

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id,
                       @RequestBody PostsUpdateRequestDto requestDto)
    {
        return postsService.update(id, requestDto);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id)
    {
        postsService.delete(id);
        return id;
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id)
    {

        return postsService.findById(id);
    }

}
