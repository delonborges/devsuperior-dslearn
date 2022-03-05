package com.delonborges.dslearn.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_section")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Section implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    private String title;
    private String description;
    private Integer position;
    private String imgUri;

    @ManyToOne
    @JoinColumn(name = "prerequisite_id")
    private Section prerequisite;

    @ManyToOne
    @JoinColumn(name = "resource_id")
    private Resource resource;
}
