package com.example.election_service;

@FeignClient(name = "voter-service")
public interface VoterClient {
    @GetMapping("/api/voters/{id}")
    Voter getVoter(@PathVariable Long id);

    @PutMapping("/api/voters/{id}/mark-voted")
    void markVoterAsVoted(@PathVariable Long id);
}

@FeignClient(name = "candidate-service")
public interface CandidateClient {
    @GetMapping("/api/candidates/{id}")
    Candidate getCandidate(@PathVariable Long id);
}