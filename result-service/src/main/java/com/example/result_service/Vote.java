package com.example.result_service;



import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Vote {
    private Long id;
    private Long electionId;
    private Long voterId;
    private Long candidateId;
    private LocalDateTime timestamp;
}