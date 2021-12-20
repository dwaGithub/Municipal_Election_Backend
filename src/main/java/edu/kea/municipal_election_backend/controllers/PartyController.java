package edu.kea.municipal_election_backend.controllers;

import edu.kea.municipal_election_backend.models.Party;
import edu.kea.municipal_election_backend.repositories.PartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PartyController {

    @Autowired
    PartyRepository parties;

    @GetMapping("/parties")
    public List<Party> getAllParties(){
        return parties.findAll();
    }
}
