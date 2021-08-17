package com.codeup.blogapp.web;

import com.codeup.blogapp.data.User;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value ="/api/users", headers ="Accept=application/json" )
public class UserController {

    @GetMapping
    private List<User> getUsers() {
        return new ArrayList<>() {{
            add(new User(28376L, "moizez", "moizez@cod.com","fgjdjd", User.Role.USER));
        }};
    }

    @GetMapping("/{id}")
    private User getUsersByID(@PathVariable Long id) {
        if (id == 1) {
            return new User(1L, "moizez again", "moizez@tarkov.com", "hfaiehf", User.Role.USER);
        } else{
            return null;
        }
    }

    @PostMapping("/users")
    private void createUser(@RequestBody User user) { System.out.println(user); }

    @PutMapping("{id}")
    private void updateUsers(@PathVariable Long id, @RequestBody User user) {
        System.out.println(id);
        System.out.println(user);
    }

    @DeleteMapping("{id}")
    private void deleteUsers(@PathVariable Long id) {
        System.out.println(id);
    }
}
