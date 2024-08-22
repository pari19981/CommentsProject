package com.project.comments.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.project.comments.entity.Comments;
import com.project.comments.model.CommonResponse;

@Service
public interface CommentService {

	List<Comments> getComments();

	List<Comments> getCommentsByUserName(String username);

	List<Comments> getCommentsByDate(LocalDate date);

	List<Map<String, Object>> getCommentsByUserNameAndDate(String username, LocalDate date);

}
