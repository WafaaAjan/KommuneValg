package com.example.kommunevalg.repository;

import com.example.kommunevalg.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CandidateRepository extends JpaRepository<Candidate, Integer> {
    List<Candidate> findAllByFirstNameAndLastName (String firstName, String lastName);

    List<Candidate> findCandidatesByPartyPartyId(Integer partyId);

}
