package com.example.voter_service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VoterService {
    private final VoterRepository voterRepository;

    public Voter registerVoter(Voter voter) {
        return voterRepository.save(voter);
    }

    public List<Voter> getAllVoters() {
        return voterRepository.findAll();
    }

    public Optional<Voter> getVoterById(Long id) {
        return voterRepository.findById(id);
    }

    public Optional<Voter> getVoterByGovernmentId(String governmentId) {
        return voterRepository.findByGovernmentId(governmentId);
    }

    public void markAsVoted(Long voterId) {
        voterRepository.findById(voterId).ifPresent(voter -> {
            voter.setHasVoted(true);
            voterRepository.save(voter);
        });
    }
}