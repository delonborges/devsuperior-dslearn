package com.delonborges.dslearn.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tb_topic")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Topic implements Serializable {

    private static final long serialVersionUID = 1L;

    @ManyToMany
    @JoinTable(name = "tb_topic_likes",
               joinColumns = @JoinColumn(name = "topic_id"),
               inverseJoinColumns = @JoinColumn(name = "user_id"))
    @Setter(AccessLevel.NONE)
    private final Set<User> likes = new HashSet<>();

    @OneToMany(mappedBy = "topic")
    @Setter(AccessLevel.NONE)
    private final List<Reply> replies = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String body;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant moment;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

    @ManyToOne
    @JoinColumn(name = "offer_id")
    private Offer offer;

    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;

    @ManyToOne
    @JoinColumn(name = "reply_id")
    private Reply answer;
}
