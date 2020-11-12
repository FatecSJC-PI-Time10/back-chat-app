package com.fatec.chatapp.activities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ActivitiesRepository extends JpaRepository<ActivityModel, Long> {
    ActivityModel findById(UUID id);
}