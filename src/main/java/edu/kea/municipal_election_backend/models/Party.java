package edu.kea.municipal_election_backend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.Nullable;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Table(name="parties")
@Entity
public class Party {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String partyName;

    @Column
    @Nullable
    private int votes;

    @Column
    @Nullable
    private double votesPercentage;

    @JsonIgnore
    @OneToMany(mappedBy = "party", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Candidate> candidateList;
}
