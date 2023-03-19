package seoul.service.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class UserDto {

    private String account;
    private String password;
    private String passwordCheck;
    private String name;
    private String phoneNumber;
    private LocalDateTime createdAt;
}
