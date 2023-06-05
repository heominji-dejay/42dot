package com.dot.controller.admin;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @Value("${spring.security.oauth2.client.registration.google.client-id}")
    private String googleClientId;

    @GetMapping("/admin")
    public String login(Model model) {
        if(isAuthenticated()) {
            return "redirect:/admin/content";
        }
        model.addAttribute("googleClientId", googleClientId);
        return "admin/login";

    }

    private boolean isAuthenticated() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication != null && !("anonymousUser").equals(authentication.getName()) && authentication.isAuthenticated();
    }
}


