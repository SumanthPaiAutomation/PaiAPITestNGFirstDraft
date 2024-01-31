package POJOs;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.jackson.Jacksonized;

import java.util.List;
@Jacksonized
@Data
@Getter
@Setter
public class UsersListPOJO {
    public static List<UsersPOJO> users;
}
