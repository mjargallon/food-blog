package com.example.foodblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.foodblog.domain.Post;

/**
 * Repository for Post table extending JpaRepository
 */
@Repository
public interface PostRepository extends JpaRepository<Post, Long>  {

	 public Post findByUrl(String url);
}
