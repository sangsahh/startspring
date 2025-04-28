package ko.spring.start.startspring.membership.login.service;

import ko.spring.start.startspring.membership.login.DTO.LoginRequest;
import ko.spring.start.startspring.membership.create.entity.User;
import ko.spring.start.startspring.membership.login.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean authenticate(LoginRequest loginRequest) {
        Optional<User> userOpt = userRepository.findById(loginRequest.getId());
        String pw = passwordEncoder.encode(loginRequest.getPw());
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            return passwordEncoder.matches(user.getPw(), pw);
        }
        return false;
    }
    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}
