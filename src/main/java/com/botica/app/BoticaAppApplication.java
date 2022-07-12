package com.botica.app;

import com.botica.app.entity.Authority;
import com.botica.app.entity.User;
import com.botica.app.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class BoticaAppApplication {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    public static void main(String[] args) {
        SpringApplication.run(BoticaAppApplication.class, args);
    }

    @PostConstruct
    protected void init(){
        List<Authority> authorityList = new ArrayList<>();

        authorityList.add(createAuthority("USER","User role"));
        authorityList.add(createAuthority("ADMIN","Admin role"));

        User user = new User();

        user.setUserName("admin");
        user.setFirstName("Noemi");
        user.setLastName("Vasquez");
        user.setPassword(passwordEncoder.encode("123456"));
        user.setEnabled(true);
        user.setAuthorities(authorityList);

        userDetailsRepository.save(user);
    }

    private Authority createAuthority(String code, String description){
        Authority authority = new Authority();
        authority.setRoleCode(code);
        authority.setRoleDescription(description);
        return authority;
    }

}
