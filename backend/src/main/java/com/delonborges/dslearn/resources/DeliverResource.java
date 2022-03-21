package com.delonborges.dslearn.resources;

import com.delonborges.dslearn.dto.DeliverRevisionDTO;
import com.delonborges.dslearn.services.DeliverService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/deliveries")
public class DeliverResource {

    private final DeliverService deliverService;

    public DeliverResource(DeliverService deliverService) {
        this.deliverService = deliverService;
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> saveRevision(@PathVariable Long id, @RequestBody DeliverRevisionDTO dto) {
        deliverService.saveRevision(id, dto);
        return ResponseEntity.noContent()
                             .build();
    }
}
