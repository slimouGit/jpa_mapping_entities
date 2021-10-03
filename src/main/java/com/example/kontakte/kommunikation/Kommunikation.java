package com.example.kontakte.kommunikation;

import com.example.kontakte.person.Person;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="kommunikation")
public class Kommunikation {

    public enum KommunikationsTyp{
        EMAIL, TELEFON, INTERNETSEITE
    }

    public Kommunikation() {
    }

    public Kommunikation(KommunikationsTyp typ, String wert) {
        this.typ = typ;
        this.wert = wert;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
    private Integer id;

    @Column(name="typ")
    @Enumerated(EnumType.STRING)
    private KommunikationsTyp typ;

    @Column(name="wert")
    private String wert;

    @ManyToOne
    private Person person;

    @Override
    public String toString() {
        return "Kommunikation{" +
                "id=" + id +
                ", typ='" + typ + '\'' +
                ", wert='" + wert + '\'' +
                ", person=" + person +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Kommunikation that = (Kommunikation) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (typ != null ? !typ.equals(that.typ) : that.typ != null) return false;
        if (wert != null ? !wert.equals(that.wert) : that.wert != null) return false;
        return person != null ? person.equals(that.person) : that.person == null;
    }

    public KommunikationsTyp getTyp() {
        return typ;
    }

    public void setTyp(KommunikationsTyp typ) {
        this.typ = typ;
    }

    public String getWert() {
        return wert;
    }

    public void setWert(String wert) {
        this.wert = wert;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
