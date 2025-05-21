package pl.wsb.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.wsb.dto.*;
import pl.wsb.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 1. Lista podstawowych informacji o użytkownikach
    @GetMapping("/basic-info")
    public List<UserBasicInfoDto> getAllUsersBasicInfo() {
        return userService.getAllUsersBasicInfo();
    }

    // 2. Szczegóły użytkownika po ID
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserDetails(@PathVariable("id") Long id) {
        return userService.getUserDetails(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 3. Dodanie nowego użytkownika
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserCreateDto dto) {
        return ResponseEntity.ok(userService.createUser(dto));
    }

    // 4. Usunięcie użytkownika
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        if (userService.deleteUser(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // 5. Aktualizacja użytkownika
    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @RequestBody UserDto dto) {
        return ResponseEntity.ok(userService.updateUser(id, dto));
    }

    // 6. Wyszukiwanie po fragmencie e-maila
    @GetMapping("/search/email")
    public List<UserBasicInfoDto> searchByEmail(@RequestParam String fragment) {
        return userService.findUsersByEmailFragment(fragment);
    }

    // 7. Wyszukiwanie starszych niż X lat
    @GetMapping("/search/older-than")
    public List<UserBasicInfoDto> findOlderThan(@RequestParam int age) {
        return userService.findOlderThan(age);
    }
}
