package com.priya.springAIOllamaDemo;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/anthropic")
@CrossOrigin("*")
public class AnthropicController {

    @GetMapping("/{message}")
    public ResponseEntity<String> getAnswer(){
        return ResponseEntity.ok("Hello world");
    }
}
