package ko.spring.start.startspring.membership.create.entity;

import jakarta.persistence.*;
import ko.spring.start.startspring.membership.create.DTO.MembershipDTO;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;


@Entity
@Getter
@Setter
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userNum;

    @Column(unique = true, nullable = false)
    private String id;
    @Column(nullable = false)
    private String pw;
    @Column(unique = true ,nullable = false)
    private String nick;





}
