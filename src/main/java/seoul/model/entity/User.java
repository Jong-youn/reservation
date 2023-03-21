package seoul.model.entity;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
public class User {

    private String account;
    private String password;
    private String name;
    private String phoneNumber;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
