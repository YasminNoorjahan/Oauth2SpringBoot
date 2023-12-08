package com.springsecurity.resourceServer;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
public class controller {
    @GetMapping("/user")
    public Map<String, Object> user(Authentication authentication) {
        return Collections.singletonMap("name", ((OAuth2User) authentication.getPrincipal()).getAttributes().get("login"));
    }

    @GetMapping("/appKey")
    public String getAppKey(Authentication authentication) {
        return "564ABC890";
    }

    @GetMapping("/aboutApp")
    public String getAppInfo() {
        return "This app to explore Oauth Authorization Code grant using SpringBoot security dependencies";
    }

   }
