package com.example.result_service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ElectionResult {
    private Long electionId;
    private List<CandidateResult> candidateResults;
}

