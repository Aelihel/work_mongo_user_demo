package work.ua.mongo_user.service.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;
import java.io.Serial;

public class UserDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @NotBlank
    public String name;

    @NotBlank
    @Email
    public String email;

    @Override
    public String toString() {
        return "UserDto{" +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
