package com.resumeranker.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.resumeranker.model.ResumeRequest;

@Service
public class ResumeRankerService {

    private final WebClient webClient;

    public ResumeRankerService(@Value("${openai.api.key}") String apiKey) {
        this.webClient = WebClient.builder()
                .baseUrl("https://api.openai.com/v1")
                .defaultHeader("Authorization", "Bearer " + apiKey)
                .defaultHeader("Content-Type", "application/json")
                .build();
    }

    public String rankResume(ResumeRequest request) {
        String prompt = "Given the following job description and resume, provide a match score from 0 to 100 and a brief explanation.\n\n"
                + "Job Description:\n" + request.getJobDescription() + "\n\n"
                + "Resume:\n" + request.getResumeText();

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("model", "gpt-3.5-turbo");
        requestBody.put("messages", new Object[]{
                Map.of("role", "user", "content", prompt)
        });

        try {
            return webClient.post()
                    .uri("/chat/completions")
                    .bodyValue(requestBody)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
        } catch (Exception e) {
            return "API Error: " + e.getMessage();
        }
    }
}
