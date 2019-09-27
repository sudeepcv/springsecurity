package basicsinjava.blogspot.com.springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import basicsinjava.blogspot.com.springsecurity.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

}