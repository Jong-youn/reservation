package seoul.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import seoul.model.entity.User;
import seoul.model.repository.UserRepository;
import seoul.service.dto.UserDto;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;


    @Override
    public void signUp(UserDto dto) {
        User entity = User.builder()
                .account(dto.getAccount())
                .password(dto.getPassword())
                .name(dto.getName())
                .phoneNumber(dto.getPhoneNumber())
                .createdAt(dto.getCreatedAt())
                .updatedAt(dto.getCreatedAt()).build();

        repository.signUp(entity);
    }
}
