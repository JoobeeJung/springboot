# SpringBoot
```text
├── README
├── README.md
├── build
│   ├── classes
│   │   └── java
│   │       ├── main
│   │       │   └── com
│   │       │       └── kbstar
│   │       │           └── springboot
│   │       │               └── study
│   │       │                   ├── Application.class
│   │       │                   ├── domain
│   │       │                   │   └── posts
│   │       │                   │       ├── Posts$PostsBuilder.class
│   │       │                   │       ├── Posts.class
│   │       │                   │       └── PostsRepository.class
│   │       │                   ├── service
│   │       │                   │   └── PostsService.class
│   │       │                   └── web
│   │       │                       ├── HelloController.class
│   │       │                       ├── PostsApiController.class
│   │       │                       └── dto
│   │       │                           ├── HelloResponseDto.class
│   │       │                           ├── PostsResponseDto.class
│   │       │                           ├── PostsSaveRequestDto$PostsSaveRequestDtoBuilder.class
│   │       │                           ├── PostsSaveRequestDto.class
│   │       │                           ├── PostsUpdateRequestDto$PostsUpdateRequestDtoBuilder.class
│   │       │                           └── PostsUpdateRequestDto.class
│   │       └── test
│   │           ├── Application.class
│   │           └── com
│   │               └── kbstar
│   │                   └── springboot
│   │                       └── study
│   │                           ├── domain
│   │                           │   └── posts
│   │                           │       ├── PostRepositoryTest.class
│   │                           │       └── PostsRepositoryTest.class
│   │                           └── web
│   │                               ├── HelloControllerTest.class
│   │                               ├── PostsApiControllerTest.class
│   │                               └── dto
│   │                                   └── HelloResponseDtoTest.class
│   ├── generated
│   │   └── sources
│   │       ├── annotationProcessor
│   │       │   └── java
│   │       │       ├── main
│   │       │       └── test
│   │       └── headers
│   │           └── java
│   │               ├── main
│   │               └── test
│   ├── reports
│   │   └── tests
│   │       └── test
│   │           ├── classes
│   │           │   └── com.kbstar.springboot.study.web.PostsApiControllerTest.html
│   │           ├── css
│   │           │   ├── base-style.css
│   │           │   └── style.css
│   │           ├── index.html
│   │           ├── js
│   │           │   └── report.js
│   │           └── packages
│   │               └── com.kbstar.springboot.study.web.html
│   ├── resources
│   │   └── main
│   │       └── application.properties
│   ├── test-results
│   │   └── test
│   │       ├── TEST-com.kbstar.springboot.study.web.PostsApiControllerTest.xml
│   │       └── binary
│   │           ├── output.bin
│   │           ├── output.bin.idx
│   │           └── results.bin
│   └── tmp
│       ├── compileJava
│       │   └── previous-compilation-data.bin
│       ├── compileTestJava
│       │   └── previous-compilation-data.bin
│       └── test
├── build.gradle
├── gradle
│   └── wrapper
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
├── gradlew
├── gradlew.bat
├── settings.gradle
└── src
    ├── main
    │   ├── java
    │   │   └── com
    │   │       └── kbstar
    │   │           └── springboot
    │   │               └── study
    │   │                   ├── Application.java
    │   │                   ├── domain
    │   │                   │   └── posts
    │   │                   │       ├── Posts.java
    │   │                   │       └── PostsRepository.java
    │   │                   ├── service
    │   │                   │   └── PostsService.java
    │   │                   └── web
    │   │                       ├── HelloController.java
    │   │                       ├── PostsApiController.java
    │   │                       └── dto
    │   │                           ├── HelloResponseDto.java
    │   │                           ├── PostsResponseDto.java
    │   │                           ├── PostsSaveRequestDto.java
    │   │                           └── PostsUpdateRequestDto.java
    │   └── resources
    │       └── application.properties
    └── test
        └── java
            ├── Application.java
            └── com
                └── kbstar
                    └── springboot
                        └── study
                            ├── domain
                            │   └── posts
                            │       ├── PostRepositoryTest.java
                            │       └── PostsRepositoryTest.java
                            └── web
                                ├── HelloControllerTest.java
                                ├── PostsApiControllerTest.java
                                └── dto
                                    └── HelloResponseDtoTest.java

73 directories, 57 files


```
## SpringBoot 구조 개괄
         +-----------------------+   +-----------+
         |    Web Layer          |   |           |
         |   (controllers) (3)   |   |   DTO(1)  |
         +-----------------------+   |           |
         +-----------------------+   |           |
         |    Service Layer(2)   |   +-----------+
         |                       |   +-----------+
         +-----------------------+   |  Domain   |
         +-----------------------+   |  Model    |
         |    Repository Layer   |   | (Entity)  |
         |                       |   |  Posts    |
         +-----------------------+   +-----------+

## SpringBoot JPA 구조

### 조회
```text
+-----------------------------+
|  Java Application           |
|                             |
|     +------------------+    |
|     | JPA              |    |
|     | +--------------+ |    |            +---------+
|     | |  JDBC        + +----+---SQL--->  |   DB    |
|     | |  API         + +<---+--Return--  |         |
|     | +--------------+ |    |            +---------+
|     +------------------+    |
+-----------------------------+
```

### 저장
```text
+---------------------------------------------+
|                                             |
|   +-----------+              +------------+ |
|   |           |   (Entity)   | JPA        | |
|   |   Member  | --Persist -->|  +-------+ | |
|   |   DAO     |              |  | JDBC  | + +---(insert SQL) ---> DB
|   |           |              |  +-------+ | |
|   +-----------+              +------------+ |
|                                             |
+---------------------------------------------+
```

### 저장 및 확인
```text
+---------------------------------------------+
|                                             |
|   +-----------+              +------------+ |
|   |           |              | JPA        | |
|   |   Member  |--find(id)--->|  +-------+ | |                     +------+
|   |   DAO     |              |  | JDBC  | + +---(insert SQL) ---> |  DB  |
|   |           |    (entity)  |  | API   | | |<---- Return ------- |      |
|   |           |<-- (object) -|  +-------+ | |                     +------+
|   +-----------+              +------------+ |
|                                             |
+---------------------------------------------+
```

### 0. build.gradle 설정
```gradle
plugins {
    id 'org.springframework.boot' version '2.4.1'
    id 'io.spring.dependency-management' version '1.0.10.RELEASE'
    id 'java'
}

group 'com.kbstar'
version '1.0.4-SNAPSHOT-' + new Date().format("yyyyMMddHHmmss")
sourceCompatibility = 1.8

repositories {
    mavenCentral()
    jcenter()
}

test {
    useJUnitPlatform()
}

dependencies {
    implementation('org.springframework.boot:spring-boot-starter-web')
    implementation('org.springframework.boot:spring-boot-starter-mustache')

    // 04-1 Lombok
    // 추가후 Ctrl+Shift+O
    implementation('org.projectlombok:lombok')

    // 07 getter가 정상적으로 동작하기 위해 추가
    // 뭔가가 변경되면 항상 새로고침(Sync)
    // HelloResponseDtoTest 단위테스트
    annotationProcessor('org.projectlombok:lombok')
    testImplementation('org.projectlombok:lombok')
    testAnnotationProcessor('org.projectlombok:lombok')

    // 12. JPA : use in-memory databse H2DB ==> Sync
    implementation('org.springframework.boot:spring-boot-starter-data-jpa')
    implementation('com.h2database:h2')

    testImplementation ('org.springframework.boot:spring-boot-starter-test')

    //04-1 lombok
    implementation('org.projectlombok:lombok')

    implementation('org.springframework.boot:spring-boot-starter-data-jpa')
    implementation('com.h2database:h2')
}

```

### 01. SpringBoot 자동설정 (Application.java) <br>
    Path : /src/main/java/com/kbstar/springboot/study/Application
    여기서 부터 설정을 읽는다.
    항상 프로젝트의 최상단에 위치

```java
@SpringBootApplication
   public class Application {
       public static void main(String[] args)
       {
       SpringApplication.run(Application.class, args);
           // main()에서 시작
           // 내장 WAS(Web com.kbstar.springboot.study.Application Server) 실행
       }
   }
```


### 02. 설정 바꾸기 (Application.java)
    File -> Setting -> Editor -> General -> Code Completion -> Match case 해제
    -> Apply (자동완성 대소문자 구분 하지 않기 위함)

    JSP : MVC Model
    Model, View, Controller

### 03. 수기 import (HelloControllerTest.java)
##### **`HelloControllerTest.java`**

```java
package com.kbstar.springboot.study.web;

import com.kbstar.springboot.study.web.HelloController;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

// 03. 아래 import는 처음 한번 직접 타이핑(Alt-Enter)에서 없는 녀석

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers= HelloController.class)
public class HelloControllerTest {


    @Autowired
    private MockMvc mvc;


    @Test
    public void helloReturnTest() throws Exception
    {
        String hello = "hello";

        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));

    }

    @Test
    public void helloDtoTest() throws Exception
    {
        String name = "HongKilDong";
        int age = 78;

        mvc.perform(get("/hello/dto")
                        .param("name", name)
                        .param("age", String.valueOf(age)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.age", is(age)));


    }

}

/*
전체구조는 main쪽의 구조와 같아야 한다.

@ExtendWith , 이전에는 @RunWith
@WebMvcTest
    @Controller
@Autowired 자동주입 java 의 Car taxi = new Car() 의 new Car()에 해당한다고 생각하면 된다.
    field, constructor, setter

 */

```



### 04. Lombok 설치

    앞으로 할 일( Lombok  : 생성자, getter/setter를 자동으로 처리)

    전체구조는 main쪽의 구조와 같아야 한다.
    
    @ExtendWith , 이전에는 @RunWith
    @WebMvcTest
    @Controller
    @Autowired 자동주입
    field, constructor, setter
    
    Ctrl+Shift+A
    plugins => Lombok 설치 확인
    build.gradle에 추가

```gradle
dependencies {
    implementation('org.projectlombok:lombok')
    implementation('org.springframework.boot:spring-boot-starter-data-jpa')
}

```


### 05. DTO : Data Transfer Object
#### **`HelloResponseDto.java`**

```java
//@Getter : field의 get method를 자동으로 생성
//@RequreiredArgsConstructor
//선언된 field가 포함된 생성자 자동 생성

private String name;
private int age;

public HelloResponseDto(String name, int age)
{
    this.name = name;
    this.age = age;
}

public String getName()
{
    return this.name;
}

public int getAge()
{
    return this.age;
}

//    Lombok에 getter가 자동으로 생성..==> 확인
//    단위테스트로 확인 ==> main, test구조가 같다.

*/
```




### 06. Getter가 자동으로 동작하는지 단위테스트
#### **`HelloResponseDtoTest.java`**

```java
 public class HelloResponseDtoTest { 
    
    @Test
   public void lombokTest()
   {
       String name = "test";
       int age = 34;

       HelloResponseDto dto = new HelloResponseDto(name, age);
       assertThat(dto.getName()).isEqualTo(name);
       assertThat(dto.getAge()).isEqualTo(age);
   }
}

@Getter
@RequiredArgsConstructor
public class HelloResponseDto {
    private final String name;
    private final int age;
}

// REST vs. 이전 http://localhost/main.php?cmd=test&idx=3
// http://localhost/hello
// JSON(JavaScript Onbject Notation)를 매핑해준다.
// Method의 종류 : GET(Select), POST(Insert), PUT(Update), DELETE

HTTP Error Code
1xx : Trying (Request는 100번대 만)
2xx : OK
3xx : Temporary Error, Redirection Error
4xx : Permanent Error, Client Error (사용자 오류)
403 : Forbidden
404 : Not Found
405 : Method Not Allowed
5xx : Server Error
6xx : Global Error (전쟁 시 등)

스프링 부트 : POST(insert), PUT(update)을 구분
cf. DELETE (삭제)

// http://localhost:8080/hello/dto/?name=홍길동&age=78
    
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello()
    {
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name,
                                     @RequestParam("age") int age)
    {
        return new HelloResponseDto(name, age);
    }
}

```

### 07. Getter 동작을 위한 gradle 설정 추가

```gradle
    // 07 getter가 정상적으로 동작하기 위해 추가
    // 뭔가가 변경되면 항상 새로고침(Sync)
    // HelloResponseDtoTest 단위테스트
    
    annotationProcessor('org.projectlombok:lombok')
    testImplementation('org.projectlombok:lombok')
    testAnnotationProcessor('org.projectlombok:lombok')
```
### 08. DTO GET Mapping 확인
    Application.java를 실행하여 아래 url를 통해 동작하는 지 확인한다.
    http://localhost:8080/hello/dto/?name=홍길동&age=12
 <img width="464" alt="image" src="https://user-images.githubusercontent.com/49167217/164649597-f6a637ca-190c-40ab-ae18-f1e94687e954.png">

-------------

## POST SELECT

### 11. JPA
    SQL 문 없이 동작할 수 있는 프로그램
    해당하는 기능은 현재 Springboot 프레임워크만 지원하고 있음

    Java Persistence API : 자바 지속성 API
    클래스 <-> DB 자동 Mapping
    기존 방식 : 프로그래밍의 대부분이 Query
    ORM(Object Relational Mapping)
    ==> SQL의 종속성에서 벗어나게 하겠다.

    CRUD ( Create, Read,  Update, Delete)
        조회 : Member member = jpa.find(memberId)
    JPA를 사용할 때의 장점 : 수정이 매우 간단하다.(유지보수)
        객체(Class)가 변경되면 , 알아서 DB에 Update Query 날라간다.

    +--------------------------+
    |  Java Application        |
    |  +--------------------+  |
    |  | JPA                |  |
    |  |  +--------------+  |  |           +----------+
    |  |  |   JDBC API   |- |- |----SQL--->|   DB     |
    |  |  |              |<-|- |---------- |          |
    |  |  +--------------+  |  |           + ---------+
    |  +--------------------+  |
    +-------------------------+

### 12. JPA작동을 위한 gradle 설정 추가

```gradle
    // 12. JPA : use in-memory databse H2DB ==> Sync
    implementation('org.springframework.boot:spring-boot-starter-data-jpa')
    implementation('com.h2database:h2')
```

### 13. 게시글 관련 클래스 정의
    웹 프로그래밍에서는 아래와 같이 정의했음
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
#### **`Posts.java`**
```java 
@Getter
@NoArgsConstructor
@Entity
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable=false)
    private String content;

    private String author;

    // 복제생성자, Copy Constructor
    @Builder
    public Posts(String title, String content, String author)
    {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
```


### 14. 저장소를 위한 interface 생성
    Posts 클래스로 부터 DB 접근이 가능하게 해 줄 JpaRepository
    MyBatis : DAO : Data Access Object
    cf. DTO : Data Transfer Object

        JpaRepository<클래스, PrimaryKey>
        이 녀석을 상속받기만 하면 CRUD 메소드 자동생성

        Entity 클래스 = Posts
        Entity Repository = PostsRepository
        이 둘은 같은 위치에 있어야 한다.

        할 일 : 저장소 처리가 잘 되는 지 확인 ==> 단위테스트트

#### **`PostsRepository.java`**
```java
public interface PostsRepository  extends JpaRepository<Posts, Long> {

}
```


### 16. Annotation 설명

    @AfterEach : @After의 최신버전
        각 단위테스트가 끝날 때 마다 수행해야하는 작업 정의
        테스트가 DB 추가 => 실제 데이터에 영향을 미칠 수 있다.
            테스트가 실제 데이터에 영향을 주지 않도록 처리
            in-memory DB : H2DB (매번 데이터가 날라감)
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
        내부적으로 어떤일을 수행하는지 확인. => SQL Query 출력
        => main/resources/application.properties 파일을 만들어서 세팅

#### **`PostsRepositoryTest.java`**
```java

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

```

### 17.단위 테스트 쿼리를 확인하는 방법

#### **`application.properties`**
```yaml
spring.jpa.show_sql=true
```

#### 쿼리를 mysql/maria db 형태로 바꿔서 보기

#### **`application.properties`**
```yaml
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL57Dialect
spring.jpa.properties.hibernate.dialect.storage_engine=innodb
spring.datasource.hikari.jdbc-url=jdbc:h2:mem:testdb;MODE=MYSQL
spring.datasource.hikari.username=sa

# comment
# // single line comment
# /* multi line comment */
# <! -- HTML -->

# # 설정파일인 경우
# ; config.php 등
# -- db connent

```


### 18. 게시글 저장을 위한 데이터 덩어리 만들기
    데이터 필드 : id, title, content, author
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

### 19. Service 등록

#### 자동으로 만들어지는 생성
```java
  public PostsService(PostsRepository postsRepository)
    {
        this.postsRepository = postsRepository;
    }

//    Transaction : All or Nothing
```
  
    
```java
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

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;
    // private final String  name;
    // private String color;
    /* java final과는 구분해서 생각하는게 좋다. java에서는 final은 초기화를 했는데 위의 final은 초기화 필요가 없다.
        final로 선언되지 않은 생성자는 아래처럼 자동으로 생성되지 않는다. Not Null 인 args만 초기화 된다고 이해하면 좋다.
    public PostsService(PostsRepository postsRepository, String name)
    {
        this.postsRespository = postsRepository;
    }
    */


    // Long이 return 타입인 이유는 해당 transaction 이후 성공하면 해당하는 DB ID를 리턴하기 위함.
    // DB 액션은 @Transactional를 추가함으로써 all or nothing 
    @Transactional
    public Long save(PostsSaveRequestDto requestDto)
    {
        System.out.println("------------------ Post Service");
        return postsRepository.save(requestDto.toEntity()).getId();
    }

}

```

### 20. 작업순서


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

#### **`PostsApiController.java`**

```java
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

```

### 21. 단위테스트
    HTML Request/Response
    Client -----req---------> Server
            <-----res -------

          +---------------------------+
          |        HTML Header        |
          +---------------------------+
          |        HTML Body          |
          |         ...               |
          +---------------------------+
    http://localhost:12345/api/v1/posts

#### **`PostsApiControllerTest.java`**

```java
 @Test
    public void postsRegistTest() throws Exception
    {
        String title = "test title";
        String content = "test content";
        String author = "test author";

        PostsSaveRequestDto requestDto = PostsSaveRequestDto
                                            .builder()
                                                .title(title)
                                                .content(content)
                                                .author(author)
                                           .build();
        System.out.println("-------------- requestDto.title = " + requestDto.getTitle());

        // http://localhost:12345/api/v1/posts
       
        //PostsSaveRequestDto requestDto = PostsSaveRequestDto.builder()
        //        .title(title).content(content).author("author").build();

        System.out.println("-------------- dto title = " + requestDto.getTitle());

        String url = "http://localhost:" + port + "/api/v1/posts";

        System.out.println("------------------- port : " + port);

        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);

        assertThat(responseEntity.getStatusCode()).isEqualByComparingTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);
        /*
            float degree = 1.23F;
            long value = 123L;
         */

        List<Posts> all = postsRepository.findAll();
        assertThat(all.get(0).getTitle()).isEqualTo(title);
        assertThat(all.get(0).getContent()).isEqualTo(content);
    }
```
---------------

## POST UPDATE 

### 22. Post Update

    개발 순서 :
    1. DTO
    2. Service
    3. Controller

#### **`PostsUpdateRequestDto.java`**
```java
package com.kbstar.springboot.study.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsUpdateRequestDto {
    private String title;
    private String content;

    @Builder
    public PostsUpdateRequestDto(String title, String content)
    {
        this.title = title;
        this.content = content;
    }
}

```

### 23. Request에 대한 응답 데이터 만들기

          1
                 Dto(4)
          2
                Entity(5)
          3

          5를 이용해 4번을 만들기

#### **`PostsResponseDto.java`**
```java

package com.kbstar.springboot.study.web.dto;

import com.kbstar.springboot.study.domain.posts.Posts;
import lombok.Getter;

@Getter
public class PostsResponseDto {
    private Long id;
    private String title;
    private String content;
    private String author;

    public PostsResponseDto(Posts entity)
    {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }
}

```

### 24. 데이터 지속성(Consistent : 객체와 Entity의 일치)
        객체가 업데이트 되면 자동으로 DB데이터가 변경

        실제 DB에 업데이트되도록 만들기.
        DTO 작업끝났다. ----> Service로 가서 작업

#### **`Posts.java`**
```java
    public void update(String title, String content)
        {
            this.title = title;
            this.content = content;
        }

```

###  25. 업데이트를 위한 매핑 (객체랑 DB)

    등록 : /api/v1/posts    <--- 새글 등록
    수정 : /api/v1/posts/3  <--- 3번글을 수정

    1. DTO --> Service --> Controller

#### **`PostsService.java`**
```java

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto )
    {
        Posts posts = postsRepository.findById(id).orElseThrow(
                        ()-> new IllegalArgumentException("No id for Post indById(id).o: " + id) //ES6 Lamda함수와 동일
        );
    
        posts.update(requestDto.getTitle(), requestDto.getContent());
    
        return id;
    }
    
    public PostsResponseDto findById(Long id)
    {
        Posts posts = postsRepository.findById(id).orElseThrow(
                        ()-> new IllegalArgumentException("No id for Post indById(id).o: " + id)
        );
    
        return new PostsResponseDto(posts);
    }

```

###     26 수정을 위한 REST 등록
    Method : POST, PUT(0), GET, DELETE

    DTO -> Service -> Controller -> 단위테스트
#### **`PostsApiController.java`**

```java
@PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id,
                       @RequestBody PostsUpdateRequestDto requestDto)
    {
        return postsService.update(id, requestDto);
    }
@GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id)
    {
        return postsService.findById(id);
    }

```

### 27 수정하기 단위테스트
  
#### **`PostsApiControllerTest.java`**

```java
    @Test
    public void postsUpdateTest() throws Exception {
        Posts savedPosts = postsRepository.save(Posts
                                                .builder()
                                                    .title("test title")
                                                    .content("test content")
                                                    .author("test author")
                                                .build()
        );

        // 정상적으로 들어갔다면.. 맨 마지막데이터가 나옴
        Long updateId = savedPosts.getId();
        String expectedTitle = "kb title";
        String expectedContent = "kb contnet";

        PostsUpdateRequestDto requestDto = PostsUpdateRequestDto
                                            .builder()
                                                .title(expectedTitle)
                                                .content(expectedContent)
                                            .build();

        String url = "http://localhost:"+port+ "/api/v1/posts/"+updateId;
        HttpEntity<PostsUpdateRequestDto> requestEntity = new HttpEntity<>(requestDto);

        ResponseEntity<Long> responseEntity = restTemplate.exchange(
                                                                    url,
                                                                    HttpMethod.PUT,
                                                                    requestEntity,
                                                                    Long.class
                                               );   
        assertThat(responseEntity.getStatusCode()).isEqualByComparingTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);
    
        List<Posts> all = postsRepository.findAll();
        assertThat(all.get(0).getTitle()).isEqualTo(expectedTitle);
        assertThat(all.get(0).getContent()).isEqualTo(expectedContent);
        }
    }


```
