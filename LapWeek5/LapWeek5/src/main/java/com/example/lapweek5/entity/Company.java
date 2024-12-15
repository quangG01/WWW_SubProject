package com.example.lapweek5.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long compId;

    private String about;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String compName;

    @Column(nullable = false)
    private String phone;

    private String webUrl;

    @OneToOne
    @JoinColumn(name = "address", referencedColumnName = "id", unique = true)
    private Address address;

    @OneToMany(mappedBy = "company")
    private List<Job> jobs;
}
