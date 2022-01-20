package com.study.springboot.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration // 이 클래스를 빈으로 등록하는데 스프링 설정으로 사용한다는 의미
@EnableWebSecurity // 스프링 시큐리티의 기능을 활성화하겠다는 의미
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    // 시큐리티를 사용하기 위해 configure 메서드를 오버라이딩해서 시큐리티 설정 내용을 구성
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // url 요청에 대한 [허용 여부] 설정, 겹치는 부분이 있다면 뒤의 설정의 앞의 설정을 덮어씀.
        http.authorizeRequests()
                // 루트(/) url 요청에 대해서 모두에게 허용하는 세팅
                .antMatchers("/").permitAll()

                // css, js, img 아래 모든 요청에 대해서는 모두에게 허용하는 세팅
                .antMatchers("/css/**", "/js/**", "/img/**").permitAll()

                // guest 아래 모든 url 요청에 대해서 모두에게 허용하는 세팅
                .antMatchers("/guest/**").permitAll()

                // member 아래 url 요청은 [ USER ] , [ ADMIN ] 역할을 가지고 있어야한다고 세팅
                .antMatchers("/member/**").hasAnyRole("USER", "ADMIN")

                // admin 아래 url 요청은 [ ADMIN ] 역할을 가지고 있어야한다고 세팅
                .antMatchers("/admin/**").hasRole("ADMIN")

                .anyRequest().authenticated();

        // 로그인 폼 url 은 모두에게 허용하는 세팅
        http.formLogin()
                .loginPage("/loginForm") // default = /login
                .loginProcessingUrl("/j_spring_security_check") // 스프링의 시큐리티 인증 url
                .failureUrl("/loginError") // 로그인이 실패할 때 호출될 url
                .usernameParameter("j_username") // 로그인폼 JSP 에서 지정한 변수명으로 파라미터명 지정
                .passwordParameter("j_password") // 로그인폼 JSP 에서 지정한 변수명으로 파라미터명 지정
                .permitAll();

        // 로그아웃 url 요청은 모두에게 허용되는 세팅
        http.logout()
                .logoutUrl("/logout") // default
                .logoutSuccessUrl("/")
                .permitAll();

        /*
        ssl 을 사용하지 않으면 true 로 사용,
        켜놓으면 http 에서 https 에 대한 요청을 제출하는 등의 오류가 있어서
        개발중에는 꺼놓는걸 추천한다.
         */
        http.csrf().disable();
    }

    /*
    이번 예제에서는 빠른 테스트를 위해 등록이 간단한 인메모리 방식의 인증 사용자를 등록한다. ( 아래부터 )
    뒤의 예제에서 데이터베이스의 테이블에서 사용자를 SQL 문 쿼리로 구해오는 방식으로 바꿀 것.
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                // 사용자이름 : user || 비밀번호 : 1234 || 역할(role) : USER 등록
                .withUser("user").password(passwordEncoder().encode("1234")).roles("USER")

                .and()

                // 사용자이름 : admin || 비밀번호 : 1234 || 역할(role) : ADMIN 등록
                .withUser("admin").password(passwordEncoder().encode("1234")).roles("ADMIN");
                // ROLE_ADMIN 에서 ROLE_는 저동으로 붙는다.
    }

    // 비밀번호의 인코딩 방식을 정함, 디폴트를 사용하므로 임의로 코드를 변경할 필요가 없음.
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
