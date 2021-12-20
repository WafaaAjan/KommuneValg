package com.example.kommunevalg.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Party {
    @Id
    @GeneratedValue
    Integer partyId;
    String partyInitial;
    String partyName;

    @OneToMany
    @JoinColumn(name = "party_id")
    @JsonBackReference
    private Set<Candidate> candidates = new HashSet<>();

    public Party() {

    }

    public Integer getPartyId() {
        return partyId;
    }

    public void setPartyId(Integer partyId) {
        this.partyId = partyId;
    }

    public String getPartyName() {return partyName;}

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public String getPartyInitial() {return partyInitial;}

    public void setPartyInitial(String partyInitial) {this.partyInitial = partyInitial;}

    public Set<Candidate> getCandidates() {
        return candidates;
    }

    public void setCandidates(Set<Candidate> candidates) {
        this.candidates = candidates;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Party party = (Party) obj;
        return Objects.equals(partyId, party.partyId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(partyId);
    }

    @Override
    public String toString() {
        return "Party{" +
                "partyId=" + partyId +
                ", partyInitial=" + partyInitial +'\'' +
                ", partyName='" + partyName +  '\'' +
                ", candidates=" + candidates + '\'' +
                '}';
    }
}
