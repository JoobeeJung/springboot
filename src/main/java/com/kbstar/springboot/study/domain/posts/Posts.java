package com.kbstar.springboot.study.domain.posts;

import com.fasterxml.jackson.annotation.JsonTypeId;
import com.kbstar.springboot.study.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


/*
13. 게시글 관련 클래스 정의
    <form method='post' enctype='multipart/form-data' action='a.jsp'>
        <input type='file' name='upfile'>
    </form>

@Entity : JPA에서 필요한 annotation
    테이블과 클래스를 매핑해준다.
    Posts.java  -> posts 데이터베이스 테이블 매핑
    MyPosts.java -> my_post 테이블을 만든다.
        myFamilyCount (O)
        my_family_count (X)
@Id : 데이터베이스의 키 값
@GeneratedValue : 키 생성
@Column : 데이터베이스 테이블을 내부적을 생성해줄 때 사이즈 등을 설정

==> 할 일 : 저장소를 위한 PostsRepository 생성해야 한다.
            class : PostsRepository.java
 */

/*
    31: JPA Auditing을 위해서 BaseTimeEntity클래스를 상속받는다.
    Application.java 시작하는 부분에
        JPA Auditing 어노테이션을 활성화시키는 어노테이션 추가
 */
@Getter
@NoArgsConstructor
@Entity
public class Posts extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable=false)
    private String content;

    @Column(length = 100, nullable=false)
    private String author;

    // 40. view, rec에 대한 컬럼 만들기
    @Column(columnDefinition = "integer default 0", nullable = false)
    private int view;

    @Column(columnDefinition = "integer default 0", nullable = false)
    private int rec;

    // 복제생성자, Copy Constructor
    @Builder
    public Posts(String title, String content, String author)
    {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    /*
    24. 데이터 지속성(Consistent : 객체와 Entity의 일치)
        객체가 업데이트 되면 자동으로 DB데이터가 변경

        실제 DB에 업데이트되도록 만들기.
        DTO 작업끝났다. ----> Service로 가서 작업
     */

    public void update(String title, String content)
    {
        this.title = title;
        this.content = content;
    }
}
