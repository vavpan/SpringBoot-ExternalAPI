package com.example.SpringBootExternalAPI.controller;


import com.example.SpringBootExternalAPI.model.CommentModel;
import com.example.SpringBootExternalAPI.model.PostModel;
import com.example.SpringBootExternalAPI.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/posts")
    public PostModel[] getAllPosts(){
        PostModel[] response = postService.getAllPosts();
        return response;
    }


    @GetMapping("/posts/{postId}/comments")
    public CommentModel[] getAllCommentsForAPost(@PathVariable("postId") Long postId){
          return postService.getAllCommentsForAPost(postId);
    }

    @PostMapping("/posts")
    public PostModel createPost(@RequestBody PostModel postModel){

        PostModel model = postService.createPost(postModel);

        return model;

    }

    @PutMapping("/posts/{postId}")
    public PostModel updatePost(@RequestBody PostModel postModel ,  @PathVariable("postId") Long postId){

        PostModel model = postService.updatePost(postModel , postId);
        return model;
    }

    @DeleteMapping("/posts/{postId}")
    public void deletePost(@PathVariable("postId") Long postId){

        postService.deletePost(postId);

    }

}
