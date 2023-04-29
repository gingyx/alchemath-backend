package com.project.controller;

import com.project.repository.Exercise;
import com.project.repository.User;
import com.project.service.MyService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class Controller {

    private final MyService myService;

    public Controller(MyService myService) {
        this.myService = myService;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Test";
    }

    @PostMapping("/user")
    public User addUser(@RequestBody User user) {
        return myService.addUser(user);
    }

//    @GetMapping("/user/{userId}")
//    public User getUser(@PathVariable long userId) {
//        return myService.getUser(userId);
//    }
    @PostMapping("/{userId}/gamification_times")
    public void updateGamificationTimes(@PathVariable long userId, @RequestBody String gamificationTimes) {
        myService.userUpdateGamificationTimes(userId, gamificationTimes);
    }

    @PostMapping("/{userId}/leaderboard")
    public String updateLeaderboard(@PathVariable long userId, @RequestBody int score) {
        return myService.userUpdateLeaderboard(userId, score);
    }

    @PostMapping("/global_elo")
    public String getGlobalElo() {
        return myService.getGlobalElo();
    }

    @PostMapping("/{userId}/post_study")
    public void sumbitPostStudy(@PathVariable long userId, @RequestBody String postStudy) {
        myService.submitPostStudy(userId, postStudy);
    }

    @PostMapping("/exercise/{userId}")
    public void addExercise(@RequestBody Exercise exercise, @PathVariable long userId) {
        myService.addExercise(exercise, userId);
    }

}
