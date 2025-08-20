package be.burundiroots.BRBLBackEnd.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAddress;

    private String street;
    private String city;
    private String country;
    private String streetNumber;
    private String streetbox;
    private String postalCode;
    @ManyToMany(mappedBy = "Address")
    private List<User_> users = new ArrayList<>();

    public Long getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(Long idAddress) {
        this.idAddress = idAddress;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getStreetbox() {
        return streetbox;
    }

    public void setStreetbox(String streetbox) {
        this.streetbox = streetbox;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public List<User_> getUsers() {
        return users;
    }

    public void setUsers(List<User_> users) {
        this.users = users;
    }
}
