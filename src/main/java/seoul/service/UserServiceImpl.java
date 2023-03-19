package seoul.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import seoul.model.entity.User;
import seoul.model.repository.UserRepository;
import seoul.service.dto.UserDto;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final PasswordEncoder encoder;


    @Override
    public void signUp(UserDto user) {
        validateUserInfo(user);
        String encodedPassword = encoder.encode(user.getPassword());

        User entity = User.builder()
                .account(user.getAccount())
                .password(encodedPassword)
                .name(user.getName())
                .phoneNumber(user.getPhoneNumber())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getCreatedAt()).build();

        repository.signUp(entity);
    }

    private void validateUserInfo(UserDto user) {
        if (!user.getPassword().equals(user.getPasswordCheck())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다. 다시 입력해주세요.");
        }

        Long hasAccount = repository.hasAccount(user.getAccount());
        if (hasAccount.compareTo(0L) > 0) {
            throw new RuntimeException("이미 존재하는 ID 입니다. 다시 입력해주세요.");
        }
    }
}
