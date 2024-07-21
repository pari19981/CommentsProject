package com.project.comments.serviceImpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.comments.entity.Comments;
import com.project.comments.repository.CommentRepository;
import com.project.comments.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService{
	
	@Autowired
	CommentRepository commentRepository;
	
	@Override
	public List<Comments> getComments() {
	
		List<Comments> commentsList = commentRepository.findAll();
		
		return commentsList;
	}

	@Override
	public List<Comments> getCommentsByUserName(String username) {
		
		List<Comments> commentsList= commentRepository.findByUserName(username);
		
		return commentsList;
	}

	@Override
	public List<Comments> getCommentsByDate(LocalDate date) {
		
		LocalDateTime startOfDay = date.atStartOfDay();
        LocalDateTime endOfDay = date.atTime(LocalTime.MAX);
		
		List<Comments> commentsList = commentRepository.findByDateofcommentBetween(startOfDay,endOfDay);
		
		return commentsList;
	}

}
