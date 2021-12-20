package edu.kea.municipal_election_backend.models;


import lombok.Data;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Data
@Table(name="candidates")
@Entity
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Enumerated(value = EnumType.STRING)
    @Column
    private Gender gender;

    @Column
    private String municipal;

    @Column
    @Nullable
    private int personalVotes;

    @ManyToOne
    @JoinColumn(name = "party_id", updatable = true)
    @Nullable
    private Party party;

}
