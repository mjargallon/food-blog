package com.example.foodblog.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.foodblog.domain.Post;
import com.example.foodblog.service.PostService;

/**
 * Controller for serving Post actions
 */
@Controller
public class PostController {

	@Autowired
	private PostService postService;

	@GetMapping("/")
	public String index() {
		return "redirect:home";
	}

	/**
	 * Show home page with list of posts in descending order
	 * @param model
	 * @return
	 */
	@GetMapping("/home")
	public String home(Model model) {
		List<Post> posts = postService.getPosts();
		// Sort by date in descending order
		List<Post> sortedPosts = posts.stream()
		        .sorted(
		        	(o1, o2) -> -(o1.getPublicationDate().compareTo(o2.getPublicationDate())))
		        .collect(Collectors.toList());
		       
		model.addAttribute("posts", sortedPosts);
		return "home";
	}

	/**
	 * Display form for new post
	 * @param model
	 * @return
	 */
	@GetMapping("/form")
	public String formGet(Model model) {
		model.addAttribute("post", new Post());
		return "form";
	}

	/**
	 * Handles the submission of a form for new post
	 * @param post
	 * @param bindingResult
	 * @param model
	 * @return
	 */
	@PostMapping("/form")
	public String formPost(@Valid Post post, BindingResult bindingResult, Model model) {

		// If validation has no errors
		if (!bindingResult.hasErrors()) {
            model.addAttribute("isValid", true);
            
    		//Add publication date with now
    		post.setPublicationDate(new Date());
    		
    		// Save to DB and update attribute
    		Post savedPost = postService.save(post);
    		model.addAttribute("post", savedPost);
        }
		
		return "form";
	}

	/**
	 * Handles the details page of a post
	 * @param url
	 * @param model
	 * @return
	 */
	@GetMapping("/posts/{url}")
	public String postPage(@PathVariable String url, Model model) {
		// Find the post with the given url
		Post post = postService.findByUrl("/" + url + "/");
		if (post != null) {
			model.addAttribute("post", post);
			return "post_page";
		} else {
			return "error";
		}
	}

	@GetMapping("/error")
	public String error() {
		return "error";
	}
	
}
