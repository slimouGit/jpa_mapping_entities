package com.example.kontakte.kommunikation;

import com.example.kontakte.person.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KommunikationRepository  extends JpaRepository<Kommunikation, Integer> {
        @Query("SELECT k FROM Kommunikation k WHERE k.person = :person")
        List<Kommunikation> findByPerson(@Param("person") Person person);
}
