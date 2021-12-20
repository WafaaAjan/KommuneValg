package com.example.kommunevalg.controller;


import com.example.kommunevalg.model.Candidate;
import com.example.kommunevalg.model.Party;
import com.example.kommunevalg.repository.CandidateRepository;
import com.example.kommunevalg.repository.PartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class CandidateRestController {

    @Autowired
    PartyRepository partyRepository;

    @Autowired
    CandidateRepository candidateRepository;

    //oprette en kandidat
    @PostMapping(value = "/api/createCandidate", consumes = "application/json")
    public ResponseEntity<Candidate> createCandidate(@RequestBody Candidate candidate) {
        candidateRepository.save(candidate);
        return new ResponseEntity<Candidate>(candidate, HttpStatus.CREATED);
    }

    //oprette et Parti
    @PostMapping(value="/api/createParty", consumes = "application/json")
    public ResponseEntity<Party> createParty(@RequestBody Party party) {
      partyRepository.save(party);
        return new ResponseEntity<Party>(party, HttpStatus.CREATED);
    }
    // Hent en liste af alle kandidater
     @GetMapping("/api/getCandidates")
    public ResponseEntity<List<Candidate>> allCandidates() {
        return new ResponseEntity<>(candidateRepository.findAll(), HttpStatus.OK);
    }


    // Hent en kandidat ved hjælp af id
    @GetMapping("/api/getCandidate/{id}")
    public ResponseEntity<Candidate> getCandidate(@PathVariable int id) {
        Optional<Candidate> candidate = candidateRepository.findById(id);
        if (candidate.isPresent()) {
            return  new ResponseEntity<>(candidate.get(), HttpStatus.OK);
        } else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    // ret i oplysningerne for den enkelte kandidat
    @PutMapping(value = "/api/editCandidate", consumes = "application/json")
    public ResponseEntity<Candidate> saveCandidate(@RequestBody Candidate candidate) {
        candidateRepository.save(candidate);
        return new ResponseEntity<>(candidate, HttpStatus.ACCEPTED);
    }

    //slette kandidater for det enkelte parti.
    @DeleteMapping("/api/deleteCandidate/{id}")
    public ResponseEntity<Integer> deleteCandidate(@PathVariable("id") Integer id) {
        candidateRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }



}
