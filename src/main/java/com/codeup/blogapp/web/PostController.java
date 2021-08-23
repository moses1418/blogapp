package com.codeup.blogapp.web;


import com.codeup.blogapp.data.Category.Category;
import com.codeup.blogapp.data.Post.Post;
import com.codeup.blogapp.data.User.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/posts", headers = "Accept=application/json")
public class PostController {

    User user = new User("eriks");
    List<Category> categories = new ArrayList<>(){{
        add(new Category(1L, "tarkov"));
        add(new Category(2L, "call of duty"));
    }};

    @GetMapping
    private List<Post> getPost(){

        return new ArrayList<Post>(){{
            add(new Post(1L, "new post", "What a post", user, categories));
            add(new Post(2L, "second post", "What a second post", user, categories));
            add(new Post(3L, "third post", "What a third post", user, categories));

        }};
    }

    @GetMapping("{id}")
    private Post getPostById(@PathVariable Long id){

        User user = new User(1l, "moizez", "moizez@erikisnotcool.com", "12345", User.Role.USER, null);

        if (id == 1){
            return new Post(1L, "new post", "What a post", user, categories);
        } else {
            return null;
        }
    }


    @PostMapping
    private void createPost(@RequestBody Post newPost){
        System.out.println(newPost.getTitle());
        System.out.println(newPost.getContent());
    }

    @PutMapping({"{id}"})
    private void updatePost(@PathVariable Long id, @RequestBody Post post){
        System.out.println(post);
        System.out.println(id);
    }

    @DeleteMapping({"{id}"})
    private void deletePost(@PathVariable Long id){
        System.out.println(id);
    }










}
