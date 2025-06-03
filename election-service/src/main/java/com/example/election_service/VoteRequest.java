package com.example.election_service;



import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VoteRequest {
    private Long electionId;
    private Long voterId;
    private Long candidateId;
}