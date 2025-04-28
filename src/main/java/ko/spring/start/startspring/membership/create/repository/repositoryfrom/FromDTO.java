package ko.spring.start.startspring.membership.create.repository.repositoryfrom;

import ko.spring.start.startspring.membership.create.DTO.MembershipDTO;
import ko.spring.start.startspring.membership.create.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
public class FromDTO {

    public static  User fromDTO(MembershipDTO dto, PasswordEncoder passwordEncoder) {
        User user = new User();
        user.setId(dto.getId());
        user.setPw(passwordEncoder.encode(dto.getPw()));
        user.setNick(dto.getNick());
        return user;
    }
}
