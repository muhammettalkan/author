package com.alkan.author.controller;

import com.alkan.author.dto.WorkDto;
import com.alkan.author.service.WorkService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/works")
public class WorkController {

    private final WorkService workService;

    public WorkController(WorkService workService) {
        this.workService = workService;
    }

    @GetMapping("/find-by-author-id")
    public List<WorkDto> findByAuthorId(@RequestParam String authorId) {
        return workService.findByAuthorId(authorId);
    }


}
