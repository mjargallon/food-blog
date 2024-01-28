package com.example.foodblog;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.example.foodblog.domain.Post;
import com.example.foodblog.service.PostService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class FoodBlogApplication {
	
	// injects json file path
    @Value("${blog.data.file}")
    private String dataFile;

	public static void main(String[] args) {
		SpringApplication.run(FoodBlogApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(PostService postService) {
		return args -> {
			// read json and write to in-memory DB
			ObjectMapper mapper = new ObjectMapper();
			try {
				System.out.println("Loading json file: " + dataFile);
				InputStream inputStream = TypeReference.class.getResourceAsStream(dataFile);
				List<Post> posts = mapper.readValue(inputStream, new TypeReference<List<Post>>(){});
				postService.save(posts);
				// Log successful save
				System.out.println("Posts saved!");
			} catch (IOException e) {
				// Log error reading json
				System.out.println("Unable to process json file: " + e.getMessage());
			} catch (Exception e) {
				// Log error reading json
				System.out.println("Unable to save posts: " + e.getMessage());
			}
		};
	}
}
