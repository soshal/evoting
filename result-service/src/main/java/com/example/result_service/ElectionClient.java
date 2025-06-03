package com.example.result_service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "election-service")
public interface ElectionClient {
    @GetMapping("/api/elections/{electionId}/votes")
    List<Vote> getVotesForElection(@PathVariable Long electionId);
}