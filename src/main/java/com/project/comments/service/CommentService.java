package com.project.comments.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.project.comments.entity.Comments;

@Service
public interface CommentService {

	List<Comments> getComments();

	List<Comments> getCommentsByUserName(String username);

	List<Comments> getCommentsByDate(LocalDate date);

}
