package work.ua.mongo_user.service.mapper;

import work.ua.mongo_user.domain.User;
import work.ua.mongo_user.service.dto.UserDto;
import work.ua.mongo_user.service.dto.UserResponseDto;

public class UserMapper {
    public static User toEntity(UserDto dto) {
        User entity = new User();
        entity.setEmail(dto.email);
        entity.setName(dto.name);
        return entity;
    }

    public static UserResponseDto toPageableResponse(User entity) {
        UserResponseDto dto = new UserResponseDto();
        dto.id = entity.getId();
        dto.name = entity.getName();
        dto.email = entity.getEmail();
        return dto;
    }

    public static User updateEntity(User entity, UserDto dto) {
        entity.setName(dto.name);
        entity.setEmail(dto.email);
        return entity;
    }
}
