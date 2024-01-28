package com.example.foodblog.service;

import java.util.List;

import com.example.foodblog.domain.Post;

/**
 * Service for Post actions
 */
public interface PostService {
	
	public Post save(Post post);
	
	public List<Post> save(List<Post> posts);
	
	public List<Post> getPosts();
	
	public Post findByUrl(String url);
}
