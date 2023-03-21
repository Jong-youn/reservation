package seoul.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import seoul.controller.request.UserSignUpReq;
import seoul.model.entity.User;
import seoul.service.dto.UserDto;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-22T06:48:14+0900",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto toDto(UserSignUpReq request) {
        if ( request == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setAccount( request.getAccount() );
        userDto.setPassword( request.getPassword() );
        userDto.setPasswordCheck( request.getPasswordCheck() );
        userDto.setName( request.getName() );
        userDto.setPhoneNumber( request.getPhoneNumber() );
        userDto.setCreatedAt( request.getCreatedAt() );

        return userDto;
    }

    @Override
    public User toEntity(UserDto dto) {
        if ( dto == null ) {
            return null;
        }

        User user = new User();

        user.setUpdatedAt( dto.getCreatedAt() );
        user.setAccount( dto.getAccount() );
        user.setPassword( dto.getPassword() );
        user.setName( dto.getName() );
        user.setPhoneNumber( dto.getPhoneNumber() );
        user.setCreatedAt( dto.getCreatedAt() );

        return user;
    }
}
