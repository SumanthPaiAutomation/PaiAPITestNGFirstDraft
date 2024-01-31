package POJOs;

import APIUtils.UserCreateUtils;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.jackson.Jacksonized;

import static dk.brics.automaton.StringUnionOperations.build;

@Data
@Getter
@Setter
@Jacksonized
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class UsersPOJO {
    private int id;
    private String firstName;
    private String lastName;
    private int age;

    public static UsersPOJO getNewUserBody() {
       return UsersPOJO.builder()
                .id(UserCreateUtils.getUserId(300, 201))
                .firstName(UserCreateUtils.getNewFirstName())
                .lastName(UserCreateUtils.getNewLastName())
               .age(UserCreateUtils.getAge(100,1))
                .build();

    }
}

