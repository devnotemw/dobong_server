package xyz.pwmw.dobong_server.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Getter
@Setter
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    // 레퍼런스 타입(널 허용), 컬럼 타입 정의
    @Column(columnDefinition = "TEXT")
    private String name;

    // 비밀번호
    private String password;

    // 이메일
    @Column(nullable = false, unique = true)
    private String email;

    // 소셜 타입(구글, 네이버 등)
    private String socialType;

    // UID(소셜에서 자동 제공. 유저 아이디 식별)
    private String uid;

    //

}
