package com.planner.planner.participant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/participants")
public class PartcipantController {

    @Autowired
    private ParticipantRepository repository;

    @PostMapping("/{id}/confirm")
    public ResponseEntity<Participant> confirmPartcipant(@PathVariable UUID id, @RequestBody PartcipantRequestPayload payload){
        Optional<Participant> participant = this.repository.findById(id);

        if(participant.isPresent()){
            Participant rawPartcipant = participant.get();
            rawPartcipant.setConfirmed(true);
            rawPartcipant.setName(payload.name());

            this.repository.save(rawPartcipant);

            return ResponseEntity.ok(rawPartcipant);
        }

        return ResponseEntity.notFound().build();
    }
}
