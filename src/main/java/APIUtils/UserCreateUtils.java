package APIUtils;

import com.github.javafaker.Faker;

public class UserCreateUtils {


        public static String firstName="";

    public static int getUserId(int maxInt, int minInt) {
        int range = maxInt - minInt + 1;
        int userId = (int) (Math.floor(Math.random() * range) + minInt);
        return userId;
    }

    public static int getAge(int maxInt, int minInt) {
        int range = maxInt - minInt + 1;
        int userId = (int) (Math.floor(Math.random() * range) + minInt);
        return userId;
    }


    public static String getNewFirstName(){
        Faker faker=new Faker();
        firstName=faker.regexify("[a-z]{9}");
        return firstName;
    }

    public static String getNewLastName(){
        Faker faker=new Faker();
        return faker.regexify("[a-z]{9}");
    }
}
