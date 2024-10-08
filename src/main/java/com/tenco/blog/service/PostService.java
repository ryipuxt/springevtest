package com.tenco.blog.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tenco.blog.repository.interfaces.PostRepository;
import com.tenco.blog.repository.model.Post;

@Service
public class PostService {

	private final PostRepository postRepository;

	@Autowired
	public PostService(PostRepository postRepository) {
		this.postRepository = postRepository;
	}

	@Transactional
	public void createPost(Post post) {
		int result = 0;

		try {
			result = postRepository.insert(post);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (result == 0) {
			System.err.println("----------------------!");
		}
	}

	@Transactional
	public List<Post> readAllPosts(int page, int size) {
		List<Post> post = new ArrayList<>();
		int limit = size;
		int offset = (page - 1) * size;
		try {
			post = postRepository.readAllPosts(limit, offset);
		} catch (Exception e) {
		}

		return post;
	}

	@Transactional
	public void deletePost(Integer id) {
		try {
			postRepository.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Transactional
	public void updatePost(Post post) {
		try {
			postRepository.updateById(post);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public int countAll() {
		return postRepository.countAll();
	}

}
