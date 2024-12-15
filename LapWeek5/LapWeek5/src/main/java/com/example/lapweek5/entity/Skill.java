package com.example.lapweek5.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "skill")
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long skillId;

    private String skillDescription;
    private String skillName;

    @Column(columnDefinition = "TINYINT")
    private Integer type;
}
