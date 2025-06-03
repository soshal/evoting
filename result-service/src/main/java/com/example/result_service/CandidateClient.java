package com.example.result_service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "candidate-service")
public interface CandidateClient {
    @GetMapping("/api/candidates/{id}")
    Candidate getCandidate(@PathVariable Long id);
}