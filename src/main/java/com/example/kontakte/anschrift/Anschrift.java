package com.example.kontakte.anschrift;

import javax.persistence.*;

@Entity
@Table(name="anschrift")
public class Anschrift {

    public Anschrift() {
    }

    public Anschrift(String street, String housenumber, Integer zipcode, String location) {
        this.street = street;
        this.housenumber = housenumber;
        this.zipcode = zipcode;
        this.location = location;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
    private Integer id;

    @Column(name="street")
    private String street;

    @Column(name="housenumber")
    private String housenumber;

    @Column(name="zipcode")
    private Integer zipcode;

    @Column(name="location")
    private String location;

    @OneToOne(mappedBy = "anschrift", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Meldeanschrift meldeanschrift;

    @Override
    public String toString() {
        return "Anschrift{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", housenumber='" + housenumber + '\'' +
                ", zipcode=" + zipcode +
                ", location='" + location + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Anschrift anschrift = (Anschrift) o;

        if (id != null ? !id.equals(anschrift.id) : anschrift.id != null) return false;
        if (street != null ? !street.equals(anschrift.street) : anschrift.street != null) return false;
        if (housenumber != null ? !housenumber.equals(anschrift.housenumber) : anschrift.housenumber != null)
            return false;
        if (zipcode != null ? !zipcode.equals(anschrift.zipcode) : anschrift.zipcode != null) return false;
        if (location != null ? !location.equals(anschrift.location) : anschrift.location != null) return false;
        return meldeanschrift != null ? meldeanschrift.equals(anschrift.meldeanschrift) : anschrift.meldeanschrift == null;
    }

    public Integer getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHousenumber() {
        return housenumber;
    }

    public void setHousenumber(String housenumber) {
        this.housenumber = housenumber;
    }

    public Integer getZipcode() {
        return zipcode;
    }

    public void setZipcode(Integer zipcode) {
        this.zipcode = zipcode;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Meldeanschrift getMeldeanschrift() {
        return meldeanschrift;
    }

    public void setMeldeanschrift(Meldeanschrift meldeanschrift) {
        this.meldeanschrift = meldeanschrift;
    }
}
