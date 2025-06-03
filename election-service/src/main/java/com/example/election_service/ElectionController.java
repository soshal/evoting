package com.example.election_service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/elections")
@RequiredArgsConstructor
public class ElectionController {
    private final ElectionService electionService;

    @PostMapping
    public ResponseEntity<Election> createElection(@RequestBody Election election) {
        return ResponseEntity.ok(electionService.createElection(election));
    }

    @PostMapping("/vote")
    public ResponseEntity<Vote> castVote(@RequestBody VoteRequest voteRequest) {
        return ResponseEntity.ok(electionService.castVote(voteRequest));
    }

    @GetMapping("/{electionId}/votes")
    public ResponseEntity<List<Vote>> getVotesForElection(@PathVariable Long electionId) {
        return ResponseEntity.ok(electionService.getVotesForElection(electionId));
    }
}