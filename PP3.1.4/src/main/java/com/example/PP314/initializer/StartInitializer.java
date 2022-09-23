package com.example.PP314.initializer;

import com.example.PP314.model.Role;
import com.example.PP314.model.User;
import com.example.PP314.service.RoleService;
import com.example.PP314.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartInitializer implements CommandLineRunner {

    private UserService userService;
    private RoleService roleService;

    public StartInitializer(UserService userService, RoleService roleService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        Role admin = new Role();
        admin.setRoleName("ROLE_ADMIN");
        roleService.createRole(admin);
        Role user = new Role();
        user.setRoleName("ROLE_USER");
        roleService.createRole(user);

        User userAdmin = new User();
        userAdmin.setUsername("admin");
        //userAdmin.setPassword("$2y$10$d1zeFIP92Wq3RNMkXagXuewcFQFNRjl6ZygBBmVwOTYpcgczjrITi"); //admin
        userAdmin.setPassword("admin");
        userAdmin.setName("Ivan");
        userAdmin.setSurname("Ivanov");
        userAdmin.setAge(30);
        userAdmin.setEmail("admin@mail.ru");
        userService.createUser(userAdmin);
        userAdmin.addRoleToUser(admin);
        userAdmin.addRoleToUser(user);
        userService.updateUser(userAdmin, userAdmin.getId());

        User userUser = new User();
        userUser.setUsername("user");
//        userUser.setPassword("$2y$10$20cGBjL5/eK8V5Ao1xoE7u3STIljpFujLwDdFYAw5DjCTLKiSYaWS"); //user
        userUser.setPassword("user");
        userUser.setName("Sergei");
        userUser.setSurname("Sergeev");
        userUser.setAge(25);
        userUser.setEmail("user@mail.ru");
        userService.createUser(userUser);
        userUser.addRoleToUser(user);
        userService.updateUser(userUser, userUser.getId());

    }
}
