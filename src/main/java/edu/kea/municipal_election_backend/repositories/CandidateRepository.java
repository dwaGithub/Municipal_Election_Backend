package edu.kea.municipal_election_backend.repositories;

import edu.kea.municipal_election_backend.models.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {


    @Query(value = "SELECT * FROM CANDIDATES WHERE PARTY_ID = ?", nativeQuery = true)
    List<Candidate> findCandidateByPartyId(Long party_id);
}
