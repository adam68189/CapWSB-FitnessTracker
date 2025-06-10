package pl.wsb.mapper;

import pl.wsb.model.Training;
import pl.wsb.dto.*;

public class TrainingMapper {

    public static TrainingDto toDto(Training t) {
        return new TrainingDto(
                t.getId(),
                t.getUserId(),
                t.getActivity(),
                t.getDistance(),
                t.getDate(),
                t.isCompleted()
        );
    }

    public static Training fromCreateDto(TrainingCreateDto dto) {
        Training t = new Training();
        t.setUserId(dto.getUserId());
        t.setActivity(dto.getActivity());
        t.setDistance(dto.getDistance());
        t.setDate(dto.getDate());
        t.setCompleted(dto.isCompleted());
        return t;
    }
}
