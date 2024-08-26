package com.cypriel.joblisting.controller;


import com.cypriel.joblisting.repository.PostRepository;
import com.cypriel.joblisting.model.Post;
import com.cypriel.joblisting.repository.SearchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "http:"") if you add a react ui remeber to add the origin
public class PostController {

    @Autowired
    PostRepository repo;

    @Autowired
    SearchRepo searchRepo;

    @GetMapping("/posts")
    public List<Post> getAllPosts(){
        return repo.findAll();
    }

    @GetMapping("/posts/{text}")
    public List<Post> searchPosts(@PathVariable String text){
        return searchRepo.findByText(text);
    }

    @PostMapping("/post")
    public Post addPost(@RequestBody Post post){
        return repo.save(post);
    }
}
