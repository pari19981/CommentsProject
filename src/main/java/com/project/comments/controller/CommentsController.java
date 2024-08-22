package com.project.comments.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.comments.entity.Comments;
import com.project.comments.exception.ResourceNotFoundException;
import com.project.comments.model.CommonResponse;
import com.project.comments.repository.CommentRepository;
import com.project.comments.service.CommentService;

@RestController
@RequestMapping("/api/v2/comments")
public class CommentsController {

	@Autowired
	CommentService commentService;

	@Autowired
	CommentRepository commentsRepository;

	@GetMapping
	public ResponseEntity<List<Comments>> getComments() {

		List<Comments> comments = commentService.getComments();

		return ResponseEntity.status(HttpStatus.OK).body(comments);

	}

	@GetMapping("/search")
	public ResponseEntity<CommonResponse> getCommentsByUserName(
			@RequestParam(value = "username", required = false) String username,
			@RequestParam(value = "date", required = false) LocalDate date) {

		List<Map<String, Object>> comments = null;
		CommonResponse response =null;

		comments = commentService.getCommentsByUserNameAndDate(username,date);
		if (comments.size() == 0) {
			throw new ResourceNotFoundException("Comments", "username and date", username +"/" + date.toString());
		}

		response = new CommonResponse(HttpStatus.OK, comments, "Success", null);


		return ResponseEntity.status(HttpStatus.OK).body(response);

	}

}
