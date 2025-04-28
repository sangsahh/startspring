package ko.spring.start.startspring.membership.create.repository;

import ko.spring.start.startspring.membership.create.DTO.MembershipDTO;
import ko.spring.start.startspring.membership.create.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembershipRepo extends JpaRepository<User, Long> {
    boolean existsById(String id);
    boolean existsByNick(String nick);

}
