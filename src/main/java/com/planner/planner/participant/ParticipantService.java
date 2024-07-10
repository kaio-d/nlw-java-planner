package com.planner.planner.participant;

import com.planner.planner.trip.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ParticipantService {

    @Autowired
    private ParticipantRepository repository;

    public void registerParticipantsToEvent(List<String> participantsToInvite, Trip trip){
        List<Participant> participants = participantsToInvite.stream().map(email -> new Participant(email, trip)).toList();

        this.repository.saveAll(participants);

        System.out.println(participants.get(0).getId());
    }

    public void triggerConfirmationEmailToParticipants(UUID tripperId){
    }

    public void triggerConfirmationEmailToParticipant(String email){
    }

    public PartcipantCreateResponse registerPartcipantToEvent(String email, Trip trip){
        Participant newPartcipant = new Participant(email, trip);
        this.repository.save(newPartcipant);

        return new PartcipantCreateResponse(newPartcipant.getId());
    }

    public List<PartcipantData> getAllPartcipantsFromEvent(UUID tripId){
        return this.repository.findByTripId(tripId).stream()
                .map(participant -> new PartcipantData(participant.getId(),
                        participant.getName(), participant.getEmail(), participant.getConfirmed())).toList();
    }
}
