package com.fatec.chatapp.services;

import com.fatec.chatapp.dtos.ActivityDTO;
import com.fatec.chatapp.models.ActivityModel;

import  java.util.List;
import java.util.UUID;

public interface ActivitiesService {
    ActivityModel create(ActivityModel a);
    Boolean delete(UUID id);
    List<ActivityModel> getAll();
    ActivityModel findOneById(UUID id);
    ActivityModel updateActivityById(UUID id, ActivityDTO a);
}