package com.example.result_service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/results")
@RequiredArgsConstructor
public class ResultController {
    private final ResultService resultService;

    @GetMapping("/{electionId}")
    public ResponseEntity<ElectionResult> getElectionResults(@PathVariable Long electionId) {
        return ResponseEntity.ok(resultService.getElectionResults(electionId));
    }
}