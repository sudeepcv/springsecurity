package basicsinjava.blogspot.com.springsecurity;

import java.util.List;
import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
@Configuration
@EnableWebSecurity
class AppConfig extends WebSecurityConfigurerAdapter{
    @Bean
    @Override
    protected UserDetailsService userDetailsService(){
       List<UserDetails> users= new ArrayList<>();
       users.add(User.withDefaultPasswordEncoder().username("sudeep").password("password").roles("USER").build());
       return new InMemoryUserDetailsManager(users);
    }

}