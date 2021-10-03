package com.example.kontakte;

import com.example.kontakte.anschrift.Anschrift;
import com.example.kontakte.anschrift.AnschriftRepository;
import com.example.kontakte.anschrift.Meldeanschrift;
import com.example.kontakte.anschrift.MeldeanschriftRepository;
import com.example.kontakte.kommunikation.Kommunikation;
import com.example.kontakte.kommunikation.KommunikationRepository;
import com.example.kontakte.kommunikation.KommunikationService;
import com.example.kontakte.person.Person;
import com.example.kontakte.person.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class PopulateContact {

    Logger logger = LoggerFactory.getLogger(PopulateContact.class);

    private PersonRepository personRepository;
    private AnschriftRepository anschriftRepository;
    private MeldeanschriftRepository meldeanschriftRepository;
    private KommunikationRepository kommunikationRepository;
    private KommunikationService kommunikationService;

    public PopulateContact(PersonRepository personRepository, AnschriftRepository anschriftRepository, MeldeanschriftRepository meldeanschriftRepository, KommunikationRepository kommunikationRepository, KommunikationService kommunikationService) {
        this.personRepository = personRepository;
        this.anschriftRepository = anschriftRepository;
        this.meldeanschriftRepository = meldeanschriftRepository;
        this.kommunikationRepository = kommunikationRepository;
        this.kommunikationService = kommunikationService;
    }

    @Bean
    public CommandLineRunner createPerson() {
        return args -> {
            Person person = new Person("Max", "Mustermann");
            this.personRepository.save(person);
            Anschrift anschrift = new Anschrift("Musterweg", "42", 60439, "Musterstadt");
            this.anschriftRepository.save(anschrift);

            Meldeanschrift meldeanschrift = new Meldeanschrift();
            meldeanschrift.setPerson(person);
            meldeanschrift.setAnschrift(anschrift);
            this.meldeanschriftRepository.save(meldeanschrift);

            Kommunikation k1 = new Kommunikation(Kommunikation.KommunikationsTyp.EMAIL,"max@mustermann.net");
            k1.setPerson(person);
            Kommunikation k2 = new Kommunikation(Kommunikation.KommunikationsTyp.TELEFON,"069123456789");
            k2.setPerson(person);
            Kommunikation k3 = new Kommunikation(Kommunikation.KommunikationsTyp.INTERNETSEITE,"www.mustermann.net");
            k3.setPerson(person);

            this.kommunikationRepository.save(k1);
            this.kommunikationRepository.save(k2);
            this.kommunikationRepository.save(k3);

            person.setMeldeanschrift(meldeanschrift);
            person.setKommunikationen(Arrays.asList(k1, k2, k3));
            anschrift.setMeldeanschrift(meldeanschrift);

            showData(person);
        };
    }

    private void showData(Person person) {
        logger.info("Person Straße {}", person.getMeldeanschrift().getAnschrift().getStreet());

        List<Kommunikation> kommunikationen = this.kommunikationService.findByPerson(person);
        int counter = 0;
        for (Kommunikation k : kommunikationen) {
            logger.info(++counter + ". {}: {}", k.getTyp(), k.getWert());
        }

    }

}
