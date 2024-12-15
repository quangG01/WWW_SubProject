package com.example.lapweek5.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "job_skill")
public class JobSkill {
    @Id
    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;

    @Id
    @ManyToOne
    @JoinColumn(name = "skill_id")
    private Skill skill;

    private String moreInfos;

    @Column(columnDefinition = "TINYINT")
    private Integer skillLevel;
}
