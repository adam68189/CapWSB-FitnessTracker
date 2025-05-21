package pl.wsb;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import pl.wsb.model.User;
import pl.wsb.repository.UserRepository;

import java.time.LocalDate;

@Component
public class DataLoader {

    @Value("${app.load-initial-data:false}")
    private boolean loadInitialData;

    private final UserRepository userRepository;

    public DataLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostConstruct
    public void load() {
        if (loadInitialData) {
            System.out.println("Ładowanie danych testowych...");

            userRepository.save(new User("Adam", "Wolf", "adam@example.com", LocalDate.of(1990, 1, 1)));
            userRepository.save(new User("Ewa", "Nowak", "ewa@example.com", LocalDate.of(1985, 7, 15)));
        }
    }
}
