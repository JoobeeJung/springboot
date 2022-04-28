package com.kbstar.springboot.study.web;
/*
34 IndexController.java
    http://kbstar.com/
 */

import com.kbstar.springboot.study.domain.posts.PostsRepository;
import com.kbstar.springboot.study.service.PostsService;
import com.kbstar.springboot.study.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {
//    @GetMapping("/")
//    public String index()
//    {
//        return "index";
//    }

    private final PostsService postsService;
    /*
        public IndexController(PostsService postsService)
        {
            this.postsService = postsService;
        }

     */

    @GetMapping("/")
    public String index(Model model, @PageableDefault(sort="id", direction = Sort.Direction.DESC, size = 2) Pageable pageable)
    {
//        model.addAttribute("posts", postsService.findAllDesc() );
        model.addAttribute("posts",postsService.pageList(pageable));
        return "index";
    }

    // printWrite
    @GetMapping("/posts/printWrite")
    public String postWrite()
    {
        return "posts-print-write";
    }

    @GetMapping("/posts/show/{id}")
    public String postShow(@PathVariable Long id, Model model)
    {
        // 읽은 카운트 증가시키고, 가져오기
        postsService.updateView(id);

        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("posts", dto);
        return "posts-show";
    }

    @GetMapping("/posts/rec/{id}")
    public String postRec(@PathVariable Long id, Model model)
    {
        // 추천 카운트 증가시키고, 가져오기
        postsService.updateRec(id);

        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("posts", dto);
        return "posts-show";
    }

    @GetMapping("/posts/update/{id}")
    public String postUpdate(@PathVariable Long id, Model model)
    {
        // 읽은 count를 증가시키고 가져오기
        postsService.updateView(id);

        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("posts", dto);
        return "posts-print-update";
    }

}

/*
    http://kbstar.com/
    query가 없으면 index를 리턴한다.
        index.mustache 파일이 있으면 이 파일이 index파일을 대체한다.

    header, tail 분리해서, 구조를 단순화시키기

    resources/templates/layout 폴더
                               /header.mustache
 */
