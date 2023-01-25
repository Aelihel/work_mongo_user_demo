package work.ua.mongo_user.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

@Document(collection = "user")
public class User {

    @Id
    private String id;

    @Field(name = "email", write = Field.Write.NON_NULL, targetType = FieldType.STRING)
    private String email;

    @Field(name = "name", write = Field.Write.NON_NULL, targetType = FieldType.STRING)
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
