package com.study.springboot.auth;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request,
                                        HttpServletResponse response,
                                        AuthenticationException exception)
    throws IOException, ServletException {
        String loginid = request.getParameter("j_username"); // 리퀘스트에서 getParameter() 메서드로 폼 데이터의 값을 구해와 변수에 저장
        String errormsg = "";

        // Error Context
        if (exception instanceof BadCredentialsException) {
            loginFailureCount(loginid);
            errormsg = "아이디나 비밀번호가 맞지 않습니다. 다시 확인해주세요.";
        } else if (exception instanceof InternalAuthenticationServiceException) {
            loginFailureCount(loginid);
            errormsg = "아이디나 비밀번호가 맞지 않습니다. 다시 확인해주세요.";
        } else if (exception instanceof DisabledException) {
            errormsg = "계정이 비활성화되었습니다. 관리자에게 문의하세요. ";
        } else if ( exception instanceof CredentialsExpiredException ) {
            errormsg = "비밀번호 유효기간이 만료되었습니다. 관리자에게 문의하세요. ";
        }

        request.setAttribute("username", loginid);
        request.setAttribute("error_message", errormsg);

        request.getRequestDispatcher("/loginForm?error=true").forward(request, response);
    }

    // 비밀번호 3번 이상 틀릴 시 계정 잠금 처리
    protected void loginFailureCount(String username) {

    }
}
