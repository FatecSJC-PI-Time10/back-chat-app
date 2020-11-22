package com.fatec.chatapp.controllers;

import com.fatec.chatapp.services.ActivitiesServiceImpl;
import com.fatec.chatapp.dtos.ActivityDTO;
import com.fatec.chatapp.models.ActivityModel;
import com.fatec.chatapp.models.UserModel;
import com.fatec.chatapp.services.UsersServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@Api(value = "Activities")
@RequestMapping(value = "/activities")
public class ActivitiesController {

    @Autowired
    ActivitiesServiceImpl activityService;

    @Autowired
    UsersServiceImpl userService;

    @GetMapping
    public List<ActivityModel> getAll(){
        return activityService.getAll();
    }

    @GetMapping("/{id}")
    public ActivityModel getOneById(@PathVariable UUID id) {
        return activityService.findOneById(id);
    }

    @PostMapping
    public ActivityModel create(@Valid @RequestBody ActivityDTO activity) {
        UserModel usuario = userService.findOneById(activity.getUserId());
        ActivityModel model = new ActivityModel(activity.getTitle(), activity.getDescription(), usuario, activity.getIsActive());
        return activityService.create(model);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete (@PathVariable("id") UUID id) {
        return ResponseEntity.ok(activityService.delete(id));
    }

    @PutMapping("/{id}")
    public ActivityModel updateActivity(@PathVariable UUID id, @RequestBody ActivityDTO body) {
        return activityService.updateActivityById(id, body);
    }
}