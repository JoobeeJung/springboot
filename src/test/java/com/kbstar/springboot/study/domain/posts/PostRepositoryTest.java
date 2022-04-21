package com.kbstar.springboot.study.domain.posts;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest

public class PostRepositoryTest {
    @Autowired
    PostsRepository postRepository;

    @AfterEach
    public void cleanup()
    {
        postRepository.deleteAll();
    }

    @Test
    public void saveAndLoad()
    {
        String title = "테스트 제목";
        String content = "테스트 본문";

        postRepository.save( Posts.builder().title(title).content(content).author("user@kbstar.com").build() );

        List<Posts> postsList = postRepository.findAll();

        Posts posts = postsList.get(0);

        System.out.println("------------- title" + posts.getTitle());
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }
}
