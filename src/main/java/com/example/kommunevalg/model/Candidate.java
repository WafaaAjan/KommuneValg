package com.example.kommunevalg.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Candidate {
    @Id
    @GeneratedValue
    Integer cpr;
    String firstName;
    String lastName;


    @ManyToOne
    @JoinColumn(name = "party_id")
    private Party party;

    public Candidate() {

    }

    public Integer getCpr() {
        return cpr;
    }

    public void setCpr(Integer cpr) {
        this.cpr = cpr;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Party getParty() {
        return party;
    }

    public void setParty(Party party) {
        this.party = party;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Candidate candidates = (Candidate) obj;
        return Objects.equals(cpr, candidates.cpr);
    }

    @Override
    public int hashCode() {
            return Objects.hash(cpr);
        }

    @Override
    public String toString() {
        return "Candidate{" +
                "cpr=" + cpr +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", party=" + party + '\'' +
                '}';
    }
}

