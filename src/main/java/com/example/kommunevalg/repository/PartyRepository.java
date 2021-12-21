package com.example.kommunevalg.repository;

import com.example.kommunevalg.model.Party;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PartyRepository  extends JpaRepository<Party, Integer> {
    List<Party>  findAllByPartyId(Integer partyId);

}

