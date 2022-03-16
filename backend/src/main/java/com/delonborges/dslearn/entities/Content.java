package com.delonborges.dslearn.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_content")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class Content extends Lesson {

    private static final long serialVersionUID = 1L;

    private String textContent;
    private String videoUri;
}
