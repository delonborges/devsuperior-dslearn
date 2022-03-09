package com.delonborges.dslearn.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_lesson")
@Data
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
@AllArgsConstructor
public abstract class Lesson implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    private String title;
    private Integer position;

    @ManyToOne
    @JoinColumn(name = "section_id")
    private Section section;

    @ManyToMany
    @JoinTable(name = "tb_lessons_done",
               joinColumns = @JoinColumn(name = "lesson_id"),
               inverseJoinColumns = {@JoinColumn(name = "user_id"), @JoinColumn(name = "offer_id")})
    @Setter(AccessLevel.NONE)
    private final Set<Enrollment> enrollmentsDone = new HashSet<>();
}
