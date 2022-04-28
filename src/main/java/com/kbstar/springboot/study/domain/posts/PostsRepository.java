package com.kbstar.springboot.study.domain.posts;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/*
14. 저장소를 위한 interface
Posts 클래스로 부터 DB 접근이 가능하게 해 줄 JpaRepository
MyBatis : DAO : Data Access Object
        cf. DTO : Data Transfer Object

        JpaRepository<클래스, PrimaryKey>
        이 녀석을 상속받기만 하면 CRUD 메소드 자동생성

        Entity 클래스 = Posts
        Entity Repository = PostsRepository
        이 둘은 같은 위치에 있어야 한다.

        할 일 : 저장소 처리가 잘 되는 지 확인 ==> 단위테스트트
 */
public interface PostsRepository  extends JpaRepository<Posts, Long> {
    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();

    @Modifying //데이터에 영향을 미치는 쿼리(insert, update delete) java의 excute update 와 같은 역할
    @Query("UPDATE Posts p SET p.view = p.view + 1 WHERE p.id = :id")
    int updateView(Long id);

    @Modifying //데이터에 영향을 미치는 쿼리(insert, update delete) java의 excute update 와 같은 역할
    @Query("UPDATE Posts p SET p.rec = p.rec + 1 WHERE p.id = :id")
    int updateRec(Long id);

//    @Query("SELECT p FROM Pos˙eable pageable);


}

/*
    여기서 사용하는 쿼리는 RDB와 약간 차이가 있다. JPQL
 */
