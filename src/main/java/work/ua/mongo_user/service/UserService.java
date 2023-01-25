package work.ua.mongo_user.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import work.ua.mongo_user.domain.error.Errors;
import work.ua.mongo_user.domain.User;
import work.ua.mongo_user.repository.MongoUserRepository;
import work.ua.mongo_user.web.rest.exception.FLCException;
import work.ua.mongo_user.service.dto.UserDto;
import work.ua.mongo_user.service.dto.UserResponseDto;
import work.ua.mongo_user.service.mapper.UserMapper;

import java.util.Optional;

@Service
public class UserService {
    private final MongoUserRepository userRepository;

    public UserService(MongoUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String create(UserDto dto) {
        if (userRepository.existsByEmail(dto.email)) {
            throw new FLCException(Errors.USER_EXISTS_BY_EMAIL);
        }
        return userRepository.save(UserMapper.toEntity(dto)).getId();
    }

    public Page<UserResponseDto> pageable(Pageable pageable) {
        return userRepository.findAll(pageable)
                .map(UserMapper::toPageableResponse);
    }

    public void update(String id, UserDto dto) {
        if (!this.equalUserByEmail(id, dto.email)) {
            throw new FLCException(Errors.USER_EXISTS_BY_EMAIL);
        }
        userRepository.save(this.updateDocumentById(id, dto));
    }

    private boolean equalUserByEmail(String id, String email) {
        Optional<User> existsUser = userRepository.findByEmail(email);
        if (existsUser.isPresent()) {
            User user = existsUser.get();
            return user.getId().equals(id);
        }
        return true;
    }

    private User updateDocumentById(String id, UserDto dto) {
        return userRepository.findById(id)
                .map(entity -> UserMapper.updateEntity(entity, dto))
                .orElseThrow(() -> new FLCException(Errors.USER_NOT_FOUND, HttpStatus.NOT_FOUND));
    }

    public void deleteById(String id) {
        userRepository.deleteById(id);
    }
}
