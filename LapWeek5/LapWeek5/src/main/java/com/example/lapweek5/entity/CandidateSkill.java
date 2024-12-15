package com.example.lapweek5.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "candidate_skill")
public class CandidateSkill {
    @Id
    @ManyToOne
    @JoinColumn(name = "can_id")
    private Candidate candidate;

    @Id
    @ManyToOne
    @JoinColumn(name = "skill_id")
    private Skill skill;

    private String moreInfos;

    @Column(columnDefinition = "TINYINT")
    private Integer skillLevel;
}
