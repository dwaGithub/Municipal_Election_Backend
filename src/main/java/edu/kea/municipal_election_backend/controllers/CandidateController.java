package edu.kea.municipal_election_backend.controllers;

import edu.kea.municipal_election_backend.DTO.CandidateDTO;
import edu.kea.municipal_election_backend.models.Candidate;
import edu.kea.municipal_election_backend.repositories.CandidateRepository;
import edu.kea.municipal_election_backend.repositories.PartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CandidateController {

    @Autowired
    CandidateRepository candidates;

    @Autowired
    PartyRepository parties;

    @GetMapping("/candidates")
    public List<Candidate> getCandidates(){
        return candidates.findAll();
    }

    @GetMapping("/candidates/{id}")
    public Candidate getCandidateById(@PathVariable Long id){
        return candidates.findById(id).get();
    }

    @GetMapping("/candidates/party/{party_id}")
    public List<Candidate> getCandidateByParty(@PathVariable Long party_id){
        return candidates.findCandidateByPartyId(party_id);
    }

    @PostMapping("/candidates/{party_id}")
    public CandidateDTO createCandidate(@PathVariable Long party_id, @RequestBody Candidate candidateToCreate){
        return parties.findById(party_id).map(party -> {
            candidateToCreate.setId(null);
            candidateToCreate.setParty(party);
            Candidate createdCandidate = candidates.save(candidateToCreate);
            return new CandidateDTO(createdCandidate, candidateToCreate.getParty().getId());
        }
        ).orElse(new CandidateDTO("Did not find the Candidate by party id"));

    }
    @PatchMapping("/candidates/{id}")
    public CandidateDTO patchCandidateById(@PathVariable Long id, @RequestBody Candidate candidateToUpdate){
        return candidates.findById(id).map(foundCandidate -> {
            if (candidateToUpdate.getName() != null) foundCandidate.setName(candidateToUpdate.getName());
            if (candidateToUpdate.getGender() != null) foundCandidate.setGender(candidateToUpdate.getGender());
            if (candidateToUpdate.getMunicipal() != null) foundCandidate.setMunicipal(candidateToUpdate.getMunicipal());
            if (candidateToUpdate.getPersonalVotes() != 0) foundCandidate.setPersonalVotes(candidateToUpdate.getPersonalVotes());
            if (candidateToUpdate.getParty() != null && candidateToUpdate.getParty().getId() != null) foundCandidate.setParty(candidateToUpdate.getParty());

            Candidate updatedCandidate = candidates.save(foundCandidate);
            return new CandidateDTO(updatedCandidate, candidateToUpdate.getParty().getId());
       }).orElse(new CandidateDTO("Kandidat ikke fundet"));
    }
    @DeleteMapping("/candidates/{id}")
    public void deleteCandidateById(@PathVariable Long id){
        candidates.deleteById(id);
    }

}
