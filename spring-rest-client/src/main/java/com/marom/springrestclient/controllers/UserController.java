package com.marom.springrestclient.controllers;

import com.marom.springrestclient.services.ApiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ServerWebExchange;

@Slf4j
@Controller
public class UserController {

    private ApiService apiService;

    public UserController(ApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping({"", "/", "/index"})
    public String index(){
        return "index";
    }

    @PostMapping("/users")
    public String formPost(Model model, ServerWebExchange serverWebExchange){

            model.addAttribute("users", apiService.getUsersReactive(serverWebExchange.getFormData()
                    .map(map -> map.get("limit").get(0))
                    .map(Integer::parseInt)));
            return "userList";
        }
}
