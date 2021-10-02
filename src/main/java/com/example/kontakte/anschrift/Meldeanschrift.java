package com.example.kontakte.anschrift;

import com.example.kontakte.person.Person;

import javax.persistence.*;

@Entity
@Table(name="meldeanschrift")
public class Meldeanschrift {
    @Id
    @Column(name = "meldeanschrift_id")
    @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="person_id")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "anschrift_id")
    private Anschrift anschrift;

    public Meldeanschrift(Person person, Anschrift anschrift) {
        this.person = person;
        this.anschrift = anschrift;
    }

    public Meldeanschrift() {

    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Anschrift getAnschrift() {
        return anschrift;
    }

    public void setAnschrift(Anschrift anschrift) {
        this.anschrift = anschrift;
    }

    public void setPerson(Integer id) {
        
    }

    public void setAnschrift(Integer id) {
    }
}
