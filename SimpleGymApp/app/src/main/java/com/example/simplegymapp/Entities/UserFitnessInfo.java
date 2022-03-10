package com.example.simplegymapp.Entities;

import java.util.ArrayList;
import java.util.List;

public class UserFitnessInfo {
    private long ID;

    private int numWeeklyWrkOut;
    private  Difficulty difficulty;
    private  WorkoutType workoutType;

    private List<Workout> workouts = new ArrayList<>();
    private User user;


    public UserFitnessInfo() {
    }

    public UserFitnessInfo(int numWeeklyWrkOut, WorkoutType workoutType, Difficulty difficulty) {
        this.numWeeklyWrkOut = numWeeklyWrkOut;
        this.workoutType = workoutType;
        this.difficulty = difficulty;
    }
    public UserFitnessInfo(int numWeeklyWrkOut) {
        this.numWeeklyWrkOut = numWeeklyWrkOut;
    }

    public int getNumWeeklyWrkOut() {
        return numWeeklyWrkOut;
    }

    public WorkoutType getWorkoutType() {
        return workoutType;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }
    public void setId(Long ID) {
        this.ID = ID;
    }

    public Long getId() {
        return ID;
    }

    public void setNumWeeklyWrkOut(int numWeeklyWrkOut) {
        this.numWeeklyWrkOut = numWeeklyWrkOut;
    }

    public void setWorkoutType(WorkoutType workoutType) {
        this.workoutType = workoutType;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }


    public List<Workout> getWorkouts() {
        return workouts;
    }

    public void setWorkouts(List<Workout> workouts) {
        this.workouts = workouts;
    }

    public void addWorkout(Workout workout) {
        this.workouts.add(workout);
    }
}
