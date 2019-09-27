package basicsinjava.blogspot.com.springsecurity;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import basicsinjava.blogspot.com.springsecurity.entity.User;
import basicsinjava.blogspot.com.springsecurity.repository.UserRepository;

@Component
public class DbInit {

    @Autowired
    private UserRepository userRepository;

    // https://www.browserling.com/tools/bcrypt

    @PostConstruct
    private void postConstruct() {
        User admin = new User("admin", "$2a$10$7j/oKt94kvu9T6nw7/TOg..66vQXl0VLA98XIwgi1C2yuMY4GbF/G");
        User normalUser = new User("user", "user");
        List<User> users= Arrays.asList(admin, normalUser);
        userRepository.saveAll(users);
    }

}