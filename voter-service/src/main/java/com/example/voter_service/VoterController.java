package com.example.voter_service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/voters")
@RequiredArgsConstructor
public class VoterController {
    private final VoterService voterService;

    @PostMapping
    public ResponseEntity<Voter> registerVoter(@RequestBody Voter voter) {
        return ResponseEntity.ok(voterService.registerVoter(voter));
    }

    @GetMapping
    public ResponseEntity<List<Voter>> getAllVoters() {
        return ResponseEntity.ok(voterService.getAllVoters());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Voter> getVoterById(@PathVariable Long id) {
        return voterService.getVoterById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/by-government-id/{governmentId}")
    public ResponseEntity<Voter> getVoterByGovernmentId(@PathVariable String governmentId) {
        return voterService.getVoterByGovernmentId(governmentId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}