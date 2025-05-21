package pl.wsb.mapper;

import pl.wsb.dto.*;
import pl.wsb.model.User;

public class UserMapper {

    public static UserDto toDto(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User is null!");
        }
        return new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getBirthDate()
        );
    }

    public static UserBasicInfoDto toBasicInfoDto(User user) {
        return new UserBasicInfoDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName()
        );
    }

    public static User fromCreateDto(UserCreateDto dto) {
        return new User(
                dto.firstName(),
                dto.lastName(),
                dto.email(),
                dto.birthDate()
        );
    }

    public static void updateUserFromDto(User user, UserDto dto) {
        user.setFirstName(dto.firstName());
        user.setLastName(dto.lastName());
        user.setEmail(dto.email());
        user.setBirthDate(dto.birthDate());
    }
}
