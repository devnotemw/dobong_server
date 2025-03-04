package xyz.pwmw.dobong_server.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class SignupRequestDto {

    @Schema(name = "name", description = "이름", example = "아무개", requiredMode = Schema.RequiredMode.REQUIRED)
    private String name;

    @Schema(name = "email", description = "이메일", example = "example@example.com", requiredMode = Schema.RequiredMode.REQUIRED)
    private String email;

    @Schema(name = "password", description = "비밀번호", example = "passwordexample", requiredMode = Schema.RequiredMode.REQUIRED)
    private String password;

    @Schema(name = "socialType", description = "소셜 로그인 타입", example = "google", requiredMode = Schema.RequiredMode.REQUIRED)
    private String socialType;

    @Schema(name = "uid", description = "uid", example = "uidexample")
    private String uid;
}
