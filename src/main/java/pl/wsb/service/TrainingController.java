package pl.wsb.service;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.wsb.dto.TrainingDto;
import pl.wsb.service.TrainingService;
import pl.wsb.dto.TrainingCreateDto;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/v1/trainings")
public class TrainingController {
    private final TrainingService trainingService;

    public TrainingController(TrainingService trainingService) {
        this.trainingService = trainingService;
    }

    @GetMapping
    public List<TrainingDto> getAll() {
        return trainingService.getAllTrainings();
    }

    @GetMapping("/user/{userId}")
    public List<TrainingDto> getByUser(@PathVariable Long userId) {
        return trainingService.getTrainingsByUserId(userId);
    }

    @GetMapping("/after-date")
    public List<TrainingDto> getAfterDate(@RequestParam String date) {
        return trainingService.getTrainingsAfterDate(LocalDate.parse(date));
    }

    @GetMapping("/activity")
    public List<TrainingDto> getByActivity(@RequestParam String activity) {
        return trainingService.getTrainingsByActivity(activity);
    }

    @PostMapping
    public ResponseEntity<TrainingDto> create(@RequestBody TrainingCreateDto dto) {
        return ResponseEntity.ok(trainingService.createTraining(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TrainingDto> update(@PathVariable Long id, @RequestBody TrainingDto dto) {
        return ResponseEntity.ok(trainingService.updateTraining(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        trainingService.deleteTraining(id);
        return ResponseEntity.noContent().build();
    }
}
