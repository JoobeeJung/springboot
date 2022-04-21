import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Alt+Enter

// 01. SpringBoot를 자동설정
// 여기서 부터 설정을 읽는다.
// 항상 프로젝트의 최상단에 위치
@SpringBootApplication
public class Application {
    public static void main(String[] args)
    {
        SpringApplication.run(Application.class, args);
        // main()에서 시작
        // 내장 WAS(Web Application Server) 실행
    }
}

// 02. 설정 바꾸기
// File -> Setting -> Editor -> General -> Code Completion -> Match case 해제
// -> Apply
// JSP : MVC Model
//      Model, View, Controller