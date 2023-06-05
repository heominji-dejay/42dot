package com.dot.config;

// 필요한 패키지들을 임포트합니다.

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

// @Component 어노테이션을 통해 이 클래스가 스프링 컴포넌트임을 선언합니다. 이를 통해 스프링이 이 클래스의 인스턴스를 자동으로 생성하고 관리합니다.
@Component
public class OAuth2LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    // onAuthenticationSuccess 메소드는 사용자가 성공적으로 로그인했을 때 호출됩니다.
    // HttpServletRequest, HttpServletResponse, Authentication 객체를 인자로 받습니다.
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        // Authentication 객체를 OAuth2AuthenticationToken 객체로 캐스팅합니다. 이 토큰 객체를 통해 OAuth2 인증 정보를 얻을 수 있습니다.
        OAuth2AuthenticationToken token = (OAuth2AuthenticationToken) authentication;
        // OAuth2AuthenticationToken 객체로부터 OAuth2User 객체를 얻습니다. 이 객체를 통해 OAuth2 사용자 정보를 얻을 수 있습니다.
        OAuth2User user = token.getPrincipal();

        // OAuth2User 객체로부터 사용자의 이메일 주소를 얻습니다.
        String email = user.getAttribute("email");
        // 이메일 주소에서 도메인 부분을 추출합니다.
        String domain = email.substring(email.indexOf("@") + 1);
        System.out.println("1");

        // 도메인이 "42dot.io"이 아닌 경우, 즉 허용되지 않은 도메인에서의 로그인 시도인 경우
        // 42dot.io로 수정해야함
        if (!"gmail.com".equals(domain)) {
            // 로그인을 거부하고, 로그인 상태를 "인증되지 않음"으로 설정합니다.
            System.out.println("2");
            authentication.setAuthenticated(false);
            // 에러 메시지를 세션에 저장합니다.
            request.getSession().setAttribute("error", "허용되지 않은 도메인에서의 로그인 시도입니다.");
            // 로그인 페이지로 리다이렉트합니다.
            response.sendRedirect("/admin/login");
        } else {
            // 도메인이 "42dot.io"인 경우, 즉 허용된 도메인에서의 로그인 시도인 경우
            // 로그인을 진행합니다.
            System.out.println("3");
            super.onAuthenticationSuccess(request, response, authentication);
            response.sendRedirect("/admin/content");
        }
    }
}
