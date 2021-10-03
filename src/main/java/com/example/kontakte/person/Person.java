package com.example.kontakte.person;

import com.example.kontakte.anschrift.Meldeanschrift;

import javax.persistence.*;

@Entity
@Table(name="person")
public class Person {

    public Person() {
    }

    public Person(String forname, String lastname) {
        this.forname = forname;
        this.lastname = lastname;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
    private Integer id;

    @Column(name="forname")
    private String forname;

    @Column(name="lastname")
    private String lastname;

    @OneToOne(mappedBy = "person", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Meldeanschrift meldeanschrift;

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", forname='" + forname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (id != null ? !id.equals(person.id) : person.id != null) return false;
        if (forname != null ? !forname.equals(person.forname) : person.forname != null) return false;
        return lastname != null ? lastname.equals(person.lastname) : person.lastname == null;
    }


    public Integer getId() {
        return id;
    }

    public String getForname() {
        return forname;
    }

    public void setForname(String forname) {
        this.forname = forname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Meldeanschrift getMeldeanschrift() {
        return meldeanschrift;
    }

    public void setMeldeanschrift(Meldeanschrift meldeanschrift) {
        this.meldeanschrift = meldeanschrift;
    }
}
