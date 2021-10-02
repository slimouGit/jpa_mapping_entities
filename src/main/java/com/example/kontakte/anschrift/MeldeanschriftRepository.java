package com.example.kontakte.anschrift;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeldeanschriftRepository extends JpaRepository<Meldeanschrift, Integer> {
}
