package com.example.election_service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ElectionService {
    private final ElectionRepository electionRepository;
    private final VoteRepository voteRepository;
    private final VoterClient voterClient;
    private final CandidateClient candidateClient;

    public Election createElection(Election election) {
        return electionRepository.save(election);
    }

    public Vote castVote(VoteRequest voteRequest) {
        // Verify voter exists and hasn't voted
        Voter voter = voterClient.getVoter(voteRequest.getVoterId());
        if (voter == null || voter.isHasVoted()) {
            throw new RuntimeException("Invalid voter or already voted");
        }

        // Verify candidate exists
        Candidate candidate = candidateClient.getCandidate(voteRequest.getCandidateId());
        if (candidate == null) {
            throw new RuntimeException("Invalid candidate");
        }

        // Verify election is active
        Election election = electionRepository.findById(voteRequest.getElectionId())
                .orElseThrow(() -> new RuntimeException("Election not found"));
        if (!election.isActive()) {
            throw new RuntimeException("Election is not active");
        }

        // Record vote
        Vote vote = new Vote();
        vote.setElectionId(voteRequest.getElectionId());
        vote.setVoterId(voteRequest.getVoterId());
        vote.setCandidateId(voteRequest.getCandidateId());
        vote.setTimestamp(LocalDateTime.now());

        // Mark voter as voted
        voterClient.markVoterAsVoted(voteRequest.getVoterId());

        return voteRepository.save(vote);
    }

    public List<Vote> getVotesForElection(Long electionId) {
        return voteRepository.findByElectionId(electionId);
    }
}