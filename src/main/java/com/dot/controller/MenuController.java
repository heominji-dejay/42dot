package com.dot.controller;

import com.dot.domain.Board;
import com.dot.domain.Menu;
import com.dot.service.BoardService;
import com.dot.service.MenuService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MenuController {

    @Autowired
    private MenuService menuService;

    @Autowired
    private BoardService boardService; // 게시판 관련 서비스

    @Autowired
    private HttpServletRequest request;


    @RequestMapping("/admin/{menuUrl}")
    public String dynamicMenu(@PathVariable String menuUrl, Model model, Authentication authentication) {
//        Menu menu = menuService.getMenuByUrl(menuUrl);
        String requestUrl = request.getRequestURI();
        Menu menu = menuService.getMenuByUrl(menuUrl);

        // Authentication 객체를 OAuth2AuthenticationToken 객체로 캐스팅합니다. 이 토큰 객체를 통해 OAuth2 인증 정보를 얻을 수 있습니다.
        OAuth2AuthenticationToken token = (OAuth2AuthenticationToken) authentication;
        // OAuth2AuthenticationToken 객체로부터 OAuth2User 객체를 얻습니다. 이 객체를 통해 OAuth2 사용자 정보를 얻을 수 있습니다.
        OAuth2User user = token.getPrincipal();

        String email = user.getAttribute("email");
        String name = user.getAttribute("name");

        System.out.println(email + name + "," +  requestUrl);

//        if (menu.getMenuUrl().equals("main")) {
//            List<Board> boardList = boardService.getBoardListByMenuId(menu.getMenuId());
//            model.addAttribute("boardList", boardList);
//            return "admin/boardView";
//        }


        if (menu != null) {
            List<Board> boardList = boardService.getBoardListByMenuId(menu.getMenuId());
            model.addAttribute("boardList", boardList);
            return "admin/boardView";
        }
        // 다른 menu_type에 대한 처리 로직...

        return "defaultView";
    }
}
