package com.example.foodblog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.foodblog.domain.Post;
import com.example.foodblog.repository.PostRepository;
import com.example.foodblog.service.PostService;

/**
 * Service implementation for PostService
 */
@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepository postRepository;

	/**
	 * Save a Post to DB
	 */
	@Override
	public Post save(Post post) {
		return postRepository.save(post);
	}

	/**
	 * Saves a list of Posts objects to DB
	 */
	@Override
	public List<Post> save(List<Post> posts) {
		return postRepository.saveAll(posts);
	}

	/**
	 * Retrieve a list of Posts objects from DB
	 */
	@Override
	public List<Post> getPosts() {
		return postRepository.findAll() ;
	}

	/**
	 * Find a Post by URL
	 */
	@Override
	public Post findByUrl(String url) {
		return postRepository.findByUrl(url);
	}
	
	
}
