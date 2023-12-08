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

    @GetMapping("/message")
    public Map<String,Object> userDetails(Authentication authentication){
        if (authentication != null && authentication.getPrincipal() instanceof OAuth2User) {
            OAuth2User oauth2User = (OAuth2User) authentication.getPrincipal();
       //     String accessToken = authentication.getDetails();
            System.out.println(((OAuth2User) authentication.getPrincipal()).getAttributes().size());
            ((OAuth2User) authentication.getPrincipal()).getAttributes().forEach((key,value) -> System.out.println(key+":"+value));
            //oauth2User.getAccessToken().getTokenValue();
            /*GitHubUser user = restTemplate.getForObject("https://api.github.com/user?access_token={token}",
                    GitHubUser.class, accessToken);
            return ResponseEntity.ok(user);*/
        }
        return null;
    }

    @GetMapping("/test")
    public String getMessage() {
        return "Hi!! ITs me";
    }
}
