package pl.wsb.service;

import org.springframework.stereotype.Service;
import pl.wsb.dto.*;
import pl.wsb.mapper.UserMapper;
import pl.wsb.model.User;
import pl.wsb.repository.UserRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserBasicInfoDto> getAllUsersBasicInfo() {
        return userRepository.findAll().stream()
                .map(UserMapper::toBasicInfoDto)
                .collect(Collectors.toList());
    }

    public Optional<UserDto> getUserDetails(Long id) {
        Optional<User> user = userRepository.findById(id);
        System.out.println("Pobrano użytkownika: " + user);
        return user.map(UserMapper::toDto);
    }

    public UserDto createUser(UserCreateDto dto) {
        User user = UserMapper.fromCreateDto(dto);
        user = userRepository.save(user);
        return UserMapper.toDto(user);
    }

    public boolean deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public UserDto updateUser(Long id, UserDto dto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

        UserMapper.updateUserFromDto(user, dto);
        user = userRepository.save(user);
        return UserMapper.toDto(user);
    }

    public List<UserBasicInfoDto> findUsersByEmailFragment(String fragment) {
        return userRepository.findByEmailContainingIgnoreCase(fragment).stream()
                .map(UserMapper::toBasicInfoDto)
                .collect(Collectors.toList());
    }

    public List<UserBasicInfoDto> findOlderThan(int age) {
        LocalDate cutoff = LocalDate.now().minusYears(age);
        return userRepository.findByBirthDateBefore(cutoff).stream()
                .map(UserMapper::toBasicInfoDto)
                .collect(Collectors.toList());
    }
}
