package ko.spring.start.startspring.membership.login.controller;

import ko.spring.start.startspring.membership.login.DTO.LoginRequest;
import ko.spring.start.startspring.membership.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest){
        System.out.println(loginRequest.getId());
        boolean isAuthenticated = userService.authenticate(loginRequest);
        if(isAuthenticated){
            return ResponseEntity.ok("로그인 성공");
        }else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인 실패");
        }
    }
}
