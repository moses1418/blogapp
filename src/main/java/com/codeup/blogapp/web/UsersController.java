package com.codeup.blogapp.web;

import com.codeup.blogapp.data.Post.Post;
import com.codeup.blogapp.data.Post.PostsRepository;
import com.codeup.blogapp.data.User.User;
import com.codeup.blogapp.data.User.UsersRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/posts", headers = "Accept=application/json", produces = "application/json")
public class UsersController {

    private final UsersRepository usersRepository;

    public UsersController(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }

    @GetMapping
    private List<User> getUsers(){
        return usersRepository.findAll();
    }

    @GetMapping("{id}")
    private User getUsersById(@PathVariable Long id){
        return usersRepository.findById(id).get();
    }

    @PostMapping
    private void createUsers(@RequestBody User newUser){

        usersRepository.save(newUser);
    }

    @PutMapping({"/{id}"})
    private void updateUser(@PathVariable Long id, @RequestBody User user){

        usersRepository.save(user);
    }

    @DeleteMapping({"{id}"})
    private void deleteUser(@PathVariable Long id){
        System.out.println("The User deleted was: " + id);
        usersRepository.deleteById(id);
    }

}