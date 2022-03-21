package com.delonborges.dslearn.services;

import com.delonborges.dslearn.dto.DeliverRevisionDTO;
import com.delonborges.dslearn.entities.Deliver;
import com.delonborges.dslearn.repositories.DeliverRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeliverService {

    private final DeliverRepository deliverRepository;

    public DeliverService(DeliverRepository deliverRepository) {
        this.deliverRepository = deliverRepository;
    }

    @Transactional
    @PreAuthorize("hasAnyRole('ADMIN', 'INSTRUCTOR')")
    public void saveRevision(Long id, DeliverRevisionDTO dto) {
        Deliver deliver = deliverRepository.getOne(id);
        deliver.setStatus(dto.getStatus());
        deliver.setFeedback(dto.getFeedback());
        deliver.setCorrectCount(dto.getCorrectCount());
        deliverRepository.save(deliver);
    }
}
