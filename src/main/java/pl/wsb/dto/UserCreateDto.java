package pl.wsb.dto;

import java.time.LocalDate;

public record UserCreateDto(
        String firstName,
        String lastName,
        String email,
        LocalDate birthDate
) {}
