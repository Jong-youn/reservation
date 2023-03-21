package seoul.service.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserDto {

    private String account;
    private String password;
    private String passwordCheck;
    private String name;
    private String phoneNumber;
    private LocalDateTime createdAt;
}
