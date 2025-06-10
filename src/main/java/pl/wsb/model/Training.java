package pl.wsb.model;

import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
@Table(name = "training")
public class Training {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private String activity;
    private double distance;
    private LocalDate date;
    private boolean completed;

    // Konstruktor bezparametrowy
    public Training() {}

    // GETTERY i SETTERY
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getActivity() { return activity; }
    public void setActivity(String activity) { this.activity = activity; }

    public double getDistance() { return distance; }
    public void setDistance(double distance) { this.distance = distance; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public boolean isCompleted() { return completed; }
    public void setCompleted(boolean completed) { this.completed = completed; }

}