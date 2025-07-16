package com.resumeranker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.resumeranker.model.ResumeRequest;
import com.resumeranker.service.ResumeRankerService;

@RestController
@RequestMapping("/api/rank")
@CrossOrigin(origins = "*")
public class ResumeController {

    @Autowired
    private ResumeRankerService rankerService;

    @PostMapping
    public String rankResume(@RequestBody ResumeRequest request) {
        return rankerService.rankResume(request);
    }

    @GetMapping("/hello")
    public String hello() {
        return "Backend is working!";
    }
}
