package work.ua.mongo_user.service.dto;

import java.io.Serial;
import java.io.Serializable;

public class UserResponseDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    public String id;

    public String name;

    public String email;

    @Override
    public String toString() {
        return "UserResponseDto{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
