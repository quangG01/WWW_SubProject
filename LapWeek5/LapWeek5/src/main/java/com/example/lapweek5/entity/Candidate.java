package com.example.lapweek5.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "candidate")
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date dob;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String fullName;

    @Column(unique = true, nullable = false)
    private String phone;

    @OneToOne
    @JoinColumn(name = "address", referencedColumnName = "id", unique = true)
    private Address address;

    @OneToMany(mappedBy = "candidate")
    private List<CandidateSkill> candidateSkills;

    public Candidate() {
    }

    public Candidate(String fullName, Date dob, String email, String phone, Address address) {
        this.fullName = fullName;
        this.dob = dob;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }
}
