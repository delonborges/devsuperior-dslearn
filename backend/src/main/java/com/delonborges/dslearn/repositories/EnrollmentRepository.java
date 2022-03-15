package com.delonborges.dslearn.repositories;

import com.delonborges.dslearn.entities.Enrollment;
import com.delonborges.dslearn.entities.pk.EnrollmentPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, EnrollmentPK> {
}
