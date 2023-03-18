package seoul.controller.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSignUpReq {

    private String account;
    private String password;
    private String passwordCheck;
    private String name;
    private String phoneNumber;

}
