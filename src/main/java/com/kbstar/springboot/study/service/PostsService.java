package com.kbstar.springboot.study.service;

import com.kbstar.springboot.study.domain.posts.PostsRepository;
import com.kbstar.springboot.study.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/*
    19. Service 등록

    자동으로 만들어지는 생성

    public PostsService(PostsRepository postsRepository)
    {
        this.postsRepository=postsRepository;
    }

    Transaction : All or Nothing
 */
@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto)
    {
        System.out.println("------------------ Post Service");
        return postsRepository.save(requestDto.toEntity()).getId();
    }

}
