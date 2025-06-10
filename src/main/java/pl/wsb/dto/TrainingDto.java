package pl.wsb.dto;

import java.time.LocalDate;

public class TrainingDto {
    private Long id;
    private Long userId;
    private String activity;
    private double distance;
    private LocalDate date;
    private boolean completed;

    public TrainingDto() {}

    public TrainingDto(Long id, Long userId, String activity, double distance, LocalDate date, boolean completed) {
        this.id = id;
        this.userId = userId;
        this.activity = activity;
        this.distance = distance;
        this.date = date;
        this.completed = completed;
    }

    // Gettery i settery
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
