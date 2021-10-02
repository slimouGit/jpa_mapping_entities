package com.example.kontakte;

import com.example.kontakte.anschrift.Anschrift;
import com.example.kontakte.anschrift.AnschriftRepository;
import com.example.kontakte.anschrift.Meldeanschrift;
import com.example.kontakte.anschrift.MeldeanschriftRepository;
import com.example.kontakte.person.Person;
import com.example.kontakte.person.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PopulateContact implements CommandLineRunner {

    private PersonRepository personRepository;
    private AnschriftRepository anschriftRepository;
    private MeldeanschriftRepository meldeanschriftRepository;

    public PopulateContact(PersonRepository personRepository, AnschriftRepository anschriftRepository, MeldeanschriftRepository meldeanschriftRepository) {
        this.personRepository = personRepository;
        this.anschriftRepository = anschriftRepository;
        this.meldeanschriftRepository = meldeanschriftRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Person person = new Person();
        person.setForname("Mimi");
        person.setLastname("Illmi");

        this.personRepository.save(person);

        Anschrift anschrift = new Anschrift();
        anschrift.setStreet("Antoninusstraße");
        anschrift.setHousenumber("64");
        anschrift.setZipcode(60439);
        anschrift.setLocation("Frankfurt");

        this.anschriftRepository.save(anschrift);

        Meldeanschrift meldeanschrift = new Meldeanschrift();
        meldeanschrift.setPerson(person.getId());
        meldeanschrift.setAnschrift(anschrift.getId());

        this.meldeanschriftRepository.save(meldeanschrift);


    }
}
