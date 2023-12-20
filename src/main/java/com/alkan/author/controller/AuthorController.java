package com.alkan.author.controller;

import com.alkan.author.response.author.AuthorResponse;
import com.alkan.author.service.AuthorService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/find")
    public AuthorResponse findAuthor(@RequestParam String name) {
        return authorService.findByName(name);
    }

}
