package ko.spring.start.startspring.membership.login.repository;

import ko.spring.start.startspring.membership.create.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findById(String id);

}
