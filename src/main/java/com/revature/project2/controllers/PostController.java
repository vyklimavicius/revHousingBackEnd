package com.revature.project2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.project2.models.Post;
import com.revature.project2.services.PostService;

@RestController
@CrossOrigin
@RequestMapping("/posts")
public class PostController {

	@Autowired
	private PostService postService;
	
	@PostMapping
	public ResponseEntity<Integer> createPost(@RequestBody Post post) {		
		int postId = postService.createPost(post);
		return new ResponseEntity<>(postId, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Post>> getPostsByZipcode(@RequestParam("zipcode") String zipcode) {
		List<Post> posts = postService.getPostsByZipcode(zipcode);
		return new ResponseEntity<>(posts, HttpStatus.OK);
	}
	
	@GetMapping("/bookmark")
	public ResponseEntity<Object> bookmarkPostById(@RequestParam("userId") int userId, @RequestParam("postId") int postId) {
		postService.bookmarkPostById(userId, postId);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
	
	@GetMapping("/unbookmark")
	public ResponseEntity<Object> unBookmarkPostById(@RequestParam("userId") int userId, @RequestParam("postId") int postId) {
		postService.unBookMarkPostById(userId, postId);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
	
	@GetMapping("/interest")
	public ResponseEntity<Object> interestPostById(@RequestParam("userId") int userId, @RequestParam("postId") int postId) {
		postService.interestPostById(userId, postId);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
	
	@GetMapping("/uninterest")
	public ResponseEntity<Object> uninterestPostById(@RequestParam("userId") int userId, @RequestParam("postId") int postId) {
		postService.unInterestPostById(userId, postId);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<List<Post>> getPostsByUserId(@PathVariable("id") int userId) {
		List<Post> posts = postService.getPostsByUserId(userId);
		return new ResponseEntity<>(posts, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Post> getPostById(@PathVariable("id") int id) {
		Post post = postService.getPostById(id);
		return new ResponseEntity<>(post, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deletePostByUserId(@PathVariable("id") int id) {
		postService.deletePostById(id);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<Object> updatePost(@RequestBody Post p) {
		postService.updatePost(p);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
	
	
}
