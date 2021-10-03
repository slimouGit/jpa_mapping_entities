package com.example.kontakte.anschrift;

import com.example.kontakte.person.Person;

import javax.persistence.*;

@Entity
@Table(name="meldeanschrift")
public class Meldeanschrift {

    public Meldeanschrift() {

    }

    public Meldeanschrift(Person person, Anschrift anschrift) {
        this.person = person;
        this.anschrift = anschrift;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="person_id")
    private Person person;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "anschrift_id")
    private Anschrift anschrift;

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
