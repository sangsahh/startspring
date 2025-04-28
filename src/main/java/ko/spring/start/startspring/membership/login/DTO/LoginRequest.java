package ko.spring.start.startspring.membership.login.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {
    private String id;
    private String pw;
}
