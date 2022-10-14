package com.example.palindromo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class Controller {
    @GetMapping
    public HashMap<String, String> helloWord() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("GET", "/");
        return hashMap;
    }
}
