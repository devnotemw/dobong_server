package xyz.pwmw.dobong_server.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.pwmw.dobong_server.dto.SignupRequestDto;
import xyz.pwmw.dobong_server.model.Users;
import xyz.pwmw.dobong_server.service.UsersService;

@Tag(name = "users", description = "유저 관련 API")
@RestController()
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UsersController {

    private final UsersService usersService;

    @GetMapping("/getAllUsers")
    @Operation(summary = "모든 유저 반환", description = "모든 유저들을 반환합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(
                    mediaType = "application/json",
                    array = @ArraySchema(schema = @Schema(implementation = Users.class))
            )),
            @ApiResponse(responseCode = "409", description = "회원 정보를 찾지 못했을 때", content = @Content(schema = @Schema(implementation = String.class))),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    public ResponseEntity<?> getAllUsers() {
        return usersService.getAllUsers();
    }

    @PostMapping("/createUser")
    @Operation(summary = "모든 유저 반환", description = "모든 유저들을 반환합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(
                    mediaType = "application/json",
                    array = @ArraySchema(schema = @Schema(implementation = Users.class))
            )),
            @ApiResponse(responseCode = "409", description = "회원 정보를 찾지 못했을 때", content = @Content(schema = @Schema(implementation = String.class))),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    public ResponseEntity<?> createUser(@RequestBody SignupRequestDto dto) {
        return usersService.createUser(dto);
    }
}
