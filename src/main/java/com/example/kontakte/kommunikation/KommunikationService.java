package com.example.kontakte.kommunikation;

import com.example.kontakte.person.Person;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KommunikationService {
    private KommunikationRepository kommunikationRepository;

    public KommunikationService(KommunikationRepository kommunikationRepository) {
        this.kommunikationRepository = kommunikationRepository;
    }

    public List<Kommunikation> findByPerson(Person person){
       return this.kommunikationRepository.findByPerson(person);
    }
}
