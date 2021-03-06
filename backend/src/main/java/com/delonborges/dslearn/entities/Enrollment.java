package com.delonborges.dslearn.entities;

import com.delonborges.dslearn.entities.pk.EnrollmentPK;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tb_enrollment")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Enrollment implements Serializable {

    private static final long serialVersionUID = 1L;

    @ManyToMany(mappedBy = "enrollmentsDone")
    @Setter(AccessLevel.NONE)
    private final Set<Lesson> lessonsDone = new HashSet<>();

    @OneToMany(mappedBy = "enrollment")
    @Setter(AccessLevel.NONE)
    private final List<Deliver> deliveries = new ArrayList<>();

    @EmbeddedId
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private EnrollmentPK id = new EnrollmentPK();

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant enrollMoment;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant refundMoment;

    private boolean available;
    private boolean onlyUpdate;

    public Enrollment(User user,
                      Offer offer,
                      Instant enrollMoment,
                      Instant refundMoment,
                      boolean available,
                      boolean onlyUpdate) {
        id.setUser(user);
        id.setOffer(offer);
        this.enrollMoment = enrollMoment;
        this.refundMoment = refundMoment;
        this.available = available;
        this.onlyUpdate = onlyUpdate;
    }

    public User getUser() {
        return id.getUser();
    }

    public void setUser(User user) {
        id.setUser(user);
    }

    public Offer getOffer() {
        return id.getOffer();
    }

    public void setOffer(Offer offer) {
        id.setOffer(offer);
    }
}
