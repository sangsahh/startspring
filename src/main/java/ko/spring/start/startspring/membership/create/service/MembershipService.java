package ko.spring.start.startspring.membership.create.service;


import ko.spring.start.startspring.membership.create.DTO.MembershipDTO;
import ko.spring.start.startspring.membership.create.entity.User;
import ko.spring.start.startspring.membership.create.repository.MembershipRepo;
import ko.spring.start.startspring.membership.create.repository.repositoryfrom.FromDTO;
import ko.spring.start.startspring.membership.login.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MembershipService {
    private final MembershipRepo membershipRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String checkId(String id){
        if(membershipRepo.existsById(id)) {
            throw new IllegalArgumentException("id가 이미 존재합니다.");
        }
        return "id 생성 가능";
    }
    public String checkUsername(String nick){
        if(membershipRepo.existsByNick(nick)) {
            throw new IllegalArgumentException("nick이 이미 존재합니다.");
        }
        return "nick 생성 가능";
    }

    public void registerUser(MembershipDTO membershipDTO){
        User user = FromDTO.fromDTO(membershipDTO, passwordEncoder);
        membershipRepo.save(user);
    }

}
