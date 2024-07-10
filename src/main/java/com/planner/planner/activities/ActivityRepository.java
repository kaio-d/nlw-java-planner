package com.planner.planner.activities;

import com.planner.planner.participant.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ActivityRepository extends JpaRepository<Activity, UUID> {
}
