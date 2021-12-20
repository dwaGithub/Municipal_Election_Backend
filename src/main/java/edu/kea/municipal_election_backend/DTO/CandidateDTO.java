package edu.kea.municipal_election_backend.DTO;

import edu.kea.municipal_election_backend.models.Candidate;

public class CandidateDTO {
    public Long party_id;
    public Candidate candidate;
    public boolean failed;
    public String errorMessage;

    public CandidateDTO(Candidate candidate, Long party_id){
        this.candidate = candidate;
        this.party_id = party_id;


    }

    public CandidateDTO(String errorMessage){
        this.errorMessage = errorMessage;
        this.failed = true;
    }
}
