# SpringBoot
```text

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
│   │       │                       └── dto
│   │       │                           ├── HelloResponseDto.class
│   │       │                           ├── PostsSaveRequestDto$PostsSaveRequestDtoBuilder.class
│   │       │                           └── PostsSaveRequestDto.class
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
│   │           │   └── com.kbstar.springboot.study.domain.posts.PostsRepositoryTest.html
│   │           ├── css
│   │           │   ├── base-style.css
│   │           │   └── style.css
│   │           ├── index.html
│   │           ├── js
│   │           │   └── report.js
│   │           └── packages
│   │               └── com.kbstar.springboot.study.domain.posts.html
│   ├── resources
│   │   └── main
│   │       └── application.properties
│   ├── test-results
│   │   └── test
│   │       ├── TEST-com.kbstar.springboot.study.domain.posts.PostsRepositoryTest.xml
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
    │   │                           └── PostsSaveRequestDto.java
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
                                └── dto
                                    └── HelloResponseDtoTest.java


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

### 1. SpringBoot 자동설정 <br>
Path : /src/main/java/com/kbstar/springboot/study/Application 
<br> 여기서 부터 설정을 읽는다.
<br> 항상 프로젝트의 최상단에 위치

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


### 2. 설정 바꾸기
 File -> Setting -> Editor -> General -> Code Completion -> Match case 해제
 -> Apply <br>
 JSP : MVC Model
      Model, View, Controller

```java
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

```



### 04. Lombok 설치
    앞으로 할 일( Lombok  : 생성자, getter/setter를 자동으로 처리)
/*
전체구조는 main쪽의 구조와 같아야 한다.

@ExtendWith , 이전에는 @RunWith
@WebMvcTest
@Controller
@Autowired 자동주입
field, constructor, setter

Ctrl+Shift+A
plugins => Lombok 설치 확인
build.gradle에 추가
*/


### 05 DTO : Data Transfer Object

```java
@Getter : field의 get method를 자동으로 생성
@RequreiredArgsConstructor
선언된 field가 포함된 생성자 자동 생성
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

    Lombok에 getter가 자동으로 생성..==> 확인
    단위테스트로 확인 ==> main, test구조가 같다.

*/
```




### 6. Getter가 자동으로 동작하는지 단위테스트
```java
 public class HelloResponseDtoTest {
   @Test
   public void lombokTest()
   {
   String name = "test";
   int age = 34;

       HelloResponseDto  dto = new HelloResponseDto(name, age);
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
// Method의 종류 : GET, POST, PUT, DELETE
/*
HTTP Error Code
1xx : Trying
2xx : OK
3xx : Temporary Error, Redirection Error
4xx : Permanent Error, Client Error
403 : Forbidden
404 : Not Found
405 : Method Not Allowed
5xx : Server Error
6xx : Global Error

    스프링 부트 : POST(insert), PUT(update)을 구분
    cf. DELETE (삭제)
    
    
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello()
    {
        return "hello";
    }

    /* 08. http://localhost:8080/hello/dto?name=홍길동&age=12
            http://localhost:8080/hello/dto/?name=홍길동&age=12
     */

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name,
                                     @RequestParam("age") int age)
    {
        return new HelloResponseDto(name, age);
    }
}

```
  


### 13. 게시글 관련 클래스 정의
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


### 14. 저장소를 위한 interface
    Posts 클래스로 부터 DB 접근이 가능하게 해 줄 JpaRepository
    MyBatis : DAO : Data Access Object
    cf. DTO : Data Transfer Object

        JpaRepository<클래스, PrimaryKey>
        이 녀석을 상속받기만 하면 CRUD 메소드 자동생성

        Entity 클래스 = Posts
        Entity Repository = PostsRepository
        이 둘은 같은 위치에 있어야 한다.

        할 일 : 저장소 처리가 잘 되는 지 확인 ==> 단위테스트트
```java
public interface PostsRepository  extends JpaRepository<Posts, Long> {

}
```


### 16. Annotation 설명

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

# 17.단위 테스트 쿼리를 확인하는 방법
spring.jpa.show_sql=true

# 18. 쿼리를 mysql/maria db 형태로 바꿔서 보기
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

```

### 20. 작업순서
```java

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

```
