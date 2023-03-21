package seoul.controller.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserSignUpReq {

    @NotBlank
    private String account;

    @NotNull
    private String password;

    @NotNull
    private String passwordCheck;

    @NotBlank
    private String name;

    @NotBlank
    private String phoneNumber;

    private LocalDateTime createdAt;
}
