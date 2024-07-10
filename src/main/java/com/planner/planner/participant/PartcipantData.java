package com.planner.planner.participant;

import java.util.UUID;

public record PartcipantData(UUID id,
                             String name,
                             String email,
                             Boolean isConfirmed) {
}
