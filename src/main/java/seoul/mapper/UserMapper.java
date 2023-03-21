package seoul.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import seoul.controller.request.UserSignUpReq;
import seoul.model.entity.User;
import seoul.service.dto.UserDto;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper {

    UserDto toDto(UserSignUpReq request);

    @Mapping(source = "createdAt", target = "updatedAt")
    User toEntity(UserDto dto);
}
