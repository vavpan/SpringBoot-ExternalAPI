package com.example.SpringBootExternalAPI.service;

import com.example.SpringBootExternalAPI.model.CommentModel;
import com.example.SpringBootExternalAPI.model.PostModel;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface PostService {


    public PostModel[] getAllPosts();

    public CommentModel[] getAllCommentsForAPost(Long postId);
    public PostModel createPost(PostModel postModel);

    public PostModel updatePost(PostModel postModel ,  Long postId);
    public void deletePost(Long postId);



}
