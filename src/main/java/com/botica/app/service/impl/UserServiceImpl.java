package com.botica.app.service.impl;

import com.botica.app.entity.Role;
import com.botica.app.entity.User;
import com.botica.app.repository.RoleRepository;
import com.botica.app.repository.UserRepository;
import com.botica.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl  implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String rolename) {
        User user = userRepository.findByUserName(username);
        Role role = roleRepository.findByName(rolename);
        user.getRoles().add(role);
        userRepository.save(user);
    }

    @Override
    public User getUser(String username) {
        return userRepository.findByUserName(username);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
