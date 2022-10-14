package com.example.palindromo.controller;

import com.example.palindromo.service.PalindromeService;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@CrossOrigin("*")
@RequestMapping("/palindrome")
@RequiredArgsConstructor
public class PalindromeController {

	@Autowired
    private  PalindromeService palindromeService;

    @PostMapping
    public HashMap<String, String> palindrome(@RequestParam String cadena) {
        return palindromeService.getPalindrome(cadena);
    }

}
