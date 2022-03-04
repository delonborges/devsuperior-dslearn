package com.delonborges.dslearn.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "tb_offer")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Offer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    private String edition;
    private Instant startMoment;
    private Instant endMoment;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
}
