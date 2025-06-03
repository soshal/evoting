package com.example.result_service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ResultService {
    private final ElectionClient electionClient;
    private final CandidateClient candidateClient;

    public ElectionResult getElectionResults(Long electionId) {
        List<Vote> votes = electionClient.getVotesForElection(electionId);

        Map<Long, Long> voteCount = votes.stream()
                .collect(Collectors.groupingBy(Vote::getCandidateId, Collectors.counting()));

        List<CandidateResult> candidateResults = voteCount.entrySet().stream()
                .map(entry -> {
                    Candidate candidate = candidateClient.getCandidate(entry.getKey());
                    return new CandidateResult(candidate, entry.getValue());
                })
                .sorted((a, b) -> Long.compare(b.getVoteCount(), a.getVoteCount()))
                .collect(Collectors.toList());

        return new ElectionResult(electionId, candidateResults);
    }
}