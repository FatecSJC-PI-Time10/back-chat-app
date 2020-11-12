package com.fatec.chatapp.activities;

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
}