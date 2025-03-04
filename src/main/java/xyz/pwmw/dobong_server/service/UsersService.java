package xyz.pwmw.dobong_server.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import xyz.pwmw.dobong_server.dto.SignupRequestDto;
import xyz.pwmw.dobong_server.model.Users;
import xyz.pwmw.dobong_server.model.UsersRepository;

@Service
@RequiredArgsConstructor
public class UsersService {
    private final UsersRepository usersRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    //Spring boot 실행시 같이 실행하는 annotation
//    @PostConstruct
//    public ResponseEntity<?> createUser() {
//        System.out.println("createUser");
//        Users users = new Users();
//        users.setName("니콜라스3");
//        users.setEmail("abc@naver.com");
//
//        //db 저장
//        Users users1 = usersRepository.save(users);
//        System.out.println("users1 = " + users1.getId() + " " + users1.getName());
//        return null;
//    }

    // 모든 유저 반환
    public ResponseEntity<?> getAllUsers(){
        return ResponseEntity.ok(usersRepository.findAll());
    }

    public ResponseEntity<?> createUser(SignupRequestDto dto) {
        String encryptedPassword = passwordEncoder.encode(dto.getPassword());
        Users user = Users.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .socialType(dto.getSocialType())
                .build();

        Users users1 = usersRepository.save(user);
        return ResponseEntity.ok(users1);
    }
}
