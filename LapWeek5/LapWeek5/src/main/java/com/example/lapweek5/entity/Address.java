package com.example.lapweek5.entity;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;
    private String city;

    @Column(columnDefinition = "SMALLINT")
    private Integer country;

    private String number;
    private String zipcode;

    public Address(String street, String city, Integer country, String number, String zipcode) {
        this.street = street;
        this.city = city;
        this.country = country;
        this.number = number;
        this.zipcode = zipcode;
    }

    public Address() {

    }
}
