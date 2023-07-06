package ru.kata.spring.boot_security.demo.Util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.repository.RoleRepository;
import ru.kata.spring.boot_security.demo.service.UserService;

import javax.annotation.PostConstruct;
import java.util.Collections;

@Component
public class Init {
    private final UserService userService;
    private final RoleRepository roleRepository;

    @Autowired
    public Init(UserService userService, RoleRepository roleRepository) {
        this.userService = userService;
        this.roleRepository = roleRepository;
    }

    @PostConstruct
    private void init() {

        Role roleUser = new Role("ROLE_USER");
        roleRepository.save(roleUser);

        Role roleAdmin = new Role("ROLE_ADMIN");
        roleRepository.save(roleAdmin);

        User user = new User();
        user.setFirstName("elina");
        user.setLastName("korotkova");
        user.setUsername("elina@mail.ru");
        user.setPassword("100");
        user.setRoles(Collections.singletonList(roleUser));
        userService.save(user);

        User user1 = new User();
        user1.setFirstName("sergey");
        user1.setLastName("ivanov");
        user1.setUsername("sergey@mail.ru");
        user1.setPassword("200");
        user1.setRoles(Collections.singletonList(roleAdmin));
        userService.save(user1);
    }

}
