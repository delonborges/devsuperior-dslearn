package com.delonborges.dslearn.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_course")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;

    @OneToMany(mappedBy = "course")
    @Setter(AccessLevel.NONE)
    private final List<Offer> offers = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    private String name;
    private String imgUri;
    private String imgGrayUri;
}
