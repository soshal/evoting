package com.example.election_service;



import lombok.Data;

@Data
public class Voter {
    private Long id;
    private String name;
    private String email;
    private String governmentId;
    private boolean hasVoted;
}
