package pl.wsb.service;

import org.springframework.stereotype.Service;
import pl.wsb.dto.TrainingDto;
import pl.wsb.mapper.TrainingMapper;
import pl.wsb.model.Training;
import pl.wsb.repository.TrainingRepository;
import pl.wsb.dto.TrainingCreateDto;


import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrainingService {
    private final TrainingRepository trainingRepository;

    public TrainingService(TrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }

    public List<TrainingDto> getAllTrainings() {
        return trainingRepository.findAll()
                .stream()
                .map(TrainingMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<TrainingDto> getTrainingsByUserId(Long userId) {
        return trainingRepository.findByUserId(userId)
                .stream()
                .map(TrainingMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<TrainingDto> getTrainingsAfterDate(LocalDate date) {
        return trainingRepository.findByDateAfter(date)
                .stream()
                .map(TrainingMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<TrainingDto> getTrainingsByActivity(String activity) {
        return trainingRepository.findByActivityIgnoreCase(activity)
                .stream()
                .map(TrainingMapper::toDto)
                .collect(Collectors.toList());
    }

    public TrainingDto createTraining(TrainingCreateDto dto) {
        Training training = TrainingMapper.fromCreateDto(dto);
        return TrainingMapper.toDto(trainingRepository.save(training));
    }

    public TrainingDto updateTraining(Long id, TrainingDto dto) {
        Training training = trainingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Training not found"));

        training.setUserId(dto.getUserId());
        training.setActivity(dto.getActivity());
        training.setDistance(dto.getDistance());
        training.setDate(dto.getDate());
        training.setCompleted(dto.isCompleted());

        return TrainingMapper.toDto(trainingRepository.save(training));
    }

    public void deleteTraining(Long id) {
        if (!trainingRepository.existsById(id)) {
            throw new RuntimeException("Training not found");
        }
        trainingRepository.deleteById(id);
    }
}
