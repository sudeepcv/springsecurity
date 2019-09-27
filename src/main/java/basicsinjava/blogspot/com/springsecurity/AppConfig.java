package basicsinjava.blogspot.com.springsecurity;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
@Configuration
@EnableWebSecurity
class AppConfig extends WebSecurityConfigurerAdapter{



    // @Override
    // protected void configure(HttpSecurity httpSecurity) throws Exception {
    //     httpSecurity.authorizeRequests().antMatchers("/").permitAll().and().authorizeRequests()
    //             .antMatchers("/h2-console/**").permitAll();
    //     httpSecurity.csrf().disable();
    //     httpSecurity.headers().frameOptions().disable();
    // }

    // @Bean
    // @Override
    // protected UserDetailsService userDetailsService(){
    //    List<UserDetails> users= new ArrayList<>();
    //    users.add(User.withDefaultPasswordEncoder().username("sudeep").password("password").roles("USER").build());
    //    return new InMemoryUserDetailsManager(users);
    // }
    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider =new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(new BCryptPasswordEncoder());
        return provider;
    }

}