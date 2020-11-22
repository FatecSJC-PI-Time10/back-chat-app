package com.fatec.chatapp.activities;

import com.fatec.chatapp.models.ActivityModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service("ActivitiesService")
public class ActivitiesServiceImpl implements ActivitiesService {
    @Autowired
    ActivitiesRepository activitiesRepository;


    @Override
    public ActivityModel create(ActivityModel a) {
        return activitiesRepository.save(a);
    }

    @Override
    public void delete (ActivityModel a) {
        activitiesRepository.delete(a);
    }

    @Override
    public List<ActivityModel> getAll() {
        return activitiesRepository.findAll();
    }

    @Override
    public ActivityModel findOneById(UUID id) {
        return activitiesRepository.findById(id);
    }

    @Override
    public ActivityModel updateActivityById(UUID id, ActivityDTO a) {
        final ActivityModel model = activitiesRepository.findById(id);

        if(a.getTitle() != null) {
            model.setTitle(a.getTitle());
        }

        if(a.getDescription() != null) {
            model.setDescription(a.getDescription());
        }

        if(a.getIsActive() != null) {
            model.setIsActive(a.getIsActive());
        }

        return activitiesRepository.save(model);
    }
}