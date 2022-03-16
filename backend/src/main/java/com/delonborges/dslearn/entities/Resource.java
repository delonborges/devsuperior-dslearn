package com.delonborges.dslearn.entities;

import com.delonborges.dslearn.entities.enums.ResourceType;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_resource")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Resource implements Serializable {

    private static final long serialVersionUID = 1L;

    @OneToMany(mappedBy = "resource")
    @Setter(AccessLevel.NONE)
    private final List<Section> sections = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    private String title;
    private String description;
    private Integer position;
    private String imgUri;
    private ResourceType type;

    @ManyToOne
    @JoinColumn(name = "offer_id")
    private Offer offer;
}
