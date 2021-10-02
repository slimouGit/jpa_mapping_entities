package com.example.kontakte.anschrift;

import javax.persistence.*;

@Entity
@Table(name="anschrift")
public class Anschrift {
    @Id
    @Column(name = "anschrift_id")
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
        return location != null ? location.equals(anschrift.location) : anschrift.location == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + (housenumber != null ? housenumber.hashCode() : 0);
        result = 31 * result + (zipcode != null ? zipcode.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        return result;
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
}
