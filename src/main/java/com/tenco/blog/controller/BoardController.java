package com.tenco.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tenco.blog.repository.model.Post;
import com.tenco.blog.service.PostService;

@Controller
public class BoardController {

	@Autowired
	PostService postService;

	@GetMapping("/index")
	public String index(Model model, @RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "size", defaultValue = "5") int size) {

		int totalRecords = postService.countAll();
		int totalPages = (int) Math.ceil((double) totalRecords / size);

		List<Post> postlist = postService.readAllPosts(page, size);
		System.err.println(postlist);

		model.addAttribute("PostList", postlist);

		model.addAttribute("currentPage", page);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("size", size);

		return "index";
	}

	@GetMapping("/board/saveForm")
	public String saveForm() {
		return "board/saveForm";
	}

	@GetMapping("/board/{id}/updateForm")
	public String updateForm(@PathVariable("id") int id, Model model) {
		model.addAttribute("id", id);
		return "board/updateForm";
	}

	@PostMapping("/board/save")
	public String save(Post post) {

		postService.createPost(post);

		return "redirect:/index";
	}

	@PostMapping("/board/{id}/update")
	public String update(@PathVariable("id") int id, Post post) {

		postService.updatePost(post);

		return "redirect:/index";
	}

	@PostMapping("/board/{id}/delete")
	public String delete(@PathVariable("id") int id) {

		postService.deletePost(id);

		return "redirect:/index";
	}
}
