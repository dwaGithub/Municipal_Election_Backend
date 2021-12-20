package edu.kea.municipal_election_backend.repositories;

import edu.kea.municipal_election_backend.models.Party;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartyRepository extends JpaRepository<Party, Long> {
}
