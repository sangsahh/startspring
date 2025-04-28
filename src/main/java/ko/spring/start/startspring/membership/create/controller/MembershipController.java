package ko.spring.start.startspring.membership.create.controller;

import ko.spring.start.startspring.membership.create.DTO.MembershipDTO;
import ko.spring.start.startspring.membership.create.entity.User;
import ko.spring.start.startspring.membership.create.service.MembershipService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MembershipController {

    private final MembershipService membershipService;

    @GetMapping("/checkid")
    public ResponseEntity<String> checkId(String id) {
        try {
            String checkid = membershipService.checkId(id);
            return ResponseEntity.ok(checkid);
        }catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/checknick")
    public ResponseEntity<String> checkNick(String nick) {
        try{
            String checknick = membershipService.checkUsername(nick);
            return ResponseEntity.ok(checknick);
        }catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody MembershipDTO user) {
        System.out.println(user.getId());  // "test123@gmail.com"
        System.out.println(user.getPw());  // "test123@"
        System.out.println(user.getNick()); // "kimsg"
        membershipService.registerUser(user);
        return ResponseEntity.ok("Ok");
    }

}
