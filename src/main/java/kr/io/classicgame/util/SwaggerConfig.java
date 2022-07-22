package kr.io.classicgame.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.annotations.ApiIgnore;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration  // 자바소스가 설정파일로 쓰인다는 의미
@EnableSwagger2 
public class SwaggerConfig {  // http://localhost/swagger-ui.html 확인하기
    @Bean// 스프링 빈으로 등록 의미
    public Docket swaggerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
          .ignoredParameterTypes(ApiIgnore.class)
          .apiInfo(swaggerInfo())
          .select()
                .apis(RequestHandlerSelectors.basePackage("kr.io.classicgame.controller"))
                .build()
                .useDefaultResponseMessages(false); // 설정한 것에 대해서만 설명을 출력 
    }
    private ApiInfo swaggerInfo() {
        return new ApiInfoBuilder().title("API Doc 입니다")
                .description("클래식 게임 홈페이지 제작을 위한 기본 문서 작성중 ")
                .license("license : playdata").licenseUrl("http://www.google.com")// 라이센스 명과 url 링크 주소 변경가능.
                .version("1").build();   }     
    }
    