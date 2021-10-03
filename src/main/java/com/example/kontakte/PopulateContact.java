package com.example.kontakte;

import com.example.kontakte.anschrift.Anschrift;
import com.example.kontakte.anschrift.AnschriftRepository;
import com.example.kontakte.anschrift.Meldeanschrift;
import com.example.kontakte.anschrift.MeldeanschriftRepository;
import com.example.kontakte.person.Person;
import com.example.kontakte.person.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class PopulateContact {

    private PersonRepository personRepository;
    private AnschriftRepository anschriftRepository;
    private MeldeanschriftRepository meldeanschriftRepository;

    public PopulateContact(PersonRepository personRepository, AnschriftRepository anschriftRepository, MeldeanschriftRepository meldeanschriftRepository) {
        this.personRepository = personRepository;
        this.anschriftRepository = anschriftRepository;
        this.meldeanschriftRepository = meldeanschriftRepository;
    }

    @Bean
    public CommandLineRunner createPerson() {
        return args -> {
            Person person = new Person("Max","Mustermann");
            this.personRepository.save(person);
            Anschrift anschrift = new Anschrift("Musterweg","42",60439,"Musterstadt");
            this.anschriftRepository.save(anschrift);

            Meldeanschrift meldeanschrift = new Meldeanschrift();
            meldeanschrift.setPerson(person);
            meldeanschrift.setAnschrift(anschrift);
            this.meldeanschriftRepository.save(meldeanschrift);

            person.setMeldeanschrift(meldeanschrift);
            anschrift.setMeldeanschrift(meldeanschrift);

            showData(person);
        };
    }

    private void showData(Person person) {
        System.out.println(person.getMeldeanschrift().getAnschrift().getStreet());
    }

}
