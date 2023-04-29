package com.project.service;

import com.project.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class MyService {
    private final UserRepository userRepository;
    private final ExerciseRepository exerciseRepository;
    private final GlobalRepository globalRepository;

    public MyService(UserRepository userRepository, ExerciseRepository exerciseRepository, GlobalRepository globalRepository) {
        this.userRepository = userRepository;
        this.exerciseRepository = exerciseRepository;
        this.globalRepository = globalRepository;
    }

    public User addUser(User user) {
        long userCount = userRepository.count();
        var savedUser = userRepository.save(user);
        savedUser.setGroupNumber((int) (userCount % 4));
        return savedUser;
    }

    public void userUpdateGamificationTimes(long userId, String gamificationTimes) {
        var user = userRepository.findById(userId).orElseThrow();
        user.setGamificationTimes(gamificationTimes);
    }

    public String userUpdateLeaderboard(long userId, int score) {
        var user = userRepository.findById(userId).orElseThrow();
        user.setLeaderboardScore(score);
        Iterable<User> users = userRepository.findAll();
        List<String> entries = new ArrayList<>();
        users.forEach(u -> {
            if (u.equals(user))
                entries.add("{\"nick\":\"" + u.getUserName() + "\",\"points\":" + u.getLeaderboardScore() + ",\"local\":true}");
            else
                entries.add("{\"nick\":\"" + u.getUserName() + "\",\"points\":" + u.getLeaderboardScore() + "}");
        });
        return Arrays.toString(entries.toArray());
    }

    public void submitPostStudy(long userId, String postStudy) {
        var user = userRepository.findById(userId).orElseThrow();
        user.setPostStudy(postStudy);
    }

    public String getGlobalElo() {
        var global = globalRepository.findById(1L).orElseThrow();
        return global.getGlobalElos();
    }

    public void addExercise(Exercise exercise, long userId) {
        var savedExercise = exerciseRepository.save(exercise);
        var user = userRepository.findById(userId).orElseThrow();
        user.addExercise(savedExercise);
    }

}
