package com.iiht.training.ratings.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iiht.training.ratings.entity.PoliticalParty;

@Repository
public interface PoliticalPartyRepository extends JpaRepository<PoliticalParty, Long> {
}
