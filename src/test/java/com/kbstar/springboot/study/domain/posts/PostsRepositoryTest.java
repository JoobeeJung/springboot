package com.kbstar.springboot.study.domain.posts;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/*
    16. Annotation 설명

    @AfterEach : @After의 최신버전
        각 단위테스트가 끝날 때 마다 수행해야하는 작업 정의
        테스트가 DB 추가 => 실제 데이터에 영향을 미칠 수 있다.
            테스트가 실제 데이터에 영향을 주지 않도록 처리
            in-memory DB : H2DB
            postsRepository.save()
                INSERT / UPDATE 둘 중 하나를 수행.
                키 값이 없으면 : INSERT
                키 값이 있으면 : UPDATE
       insert into ...
       update mytable set ... where idx='idx'

       postsRepository.findAll()
            SELECT *
            결과를 List Collection에 add()

      현재 : Test => Success
        내부적으로 어떤일을 수행하는지 확인. => Query 출력
        => main/resources/application.properties 파일을 만들어서 세팅
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PostsRepositoryTest {
    @Autowired
    PostsRepository postsRepository;

    @AfterEach
    public void cleanup()
    {
        postsRepository.deleteAll();
    }

    @Test
    public void saveAndLoad()
    {
        String title = "테스트 제목";
        String content = "테스트 본문";

        postsRepository.save( Posts.builder().title(title).content(content).author("user@kbstar.com").build());

        List<Posts> postsList = postsRepository.findAll();

        Posts posts = postsList.get(0);

        System.out.println("-------------------------- title = " + posts.getTitle());
        /*
        15 단축키 설정
            File > Settings > Keymap > Eclipse 선택

            검색창 : Live Template
                > 왼쪽 Live Template 선택
                > 오른쪽 Java 하위목록 펼친다음
                > sout~시작되는 항목 블럭선택
                > 오른쪽 마우스
                > change context
                > Java 선택
                > 적용 누르면
                sout 자동완성 됨

         */



        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);

    }
}
