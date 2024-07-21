package com.project.comments.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.comments.entity.Comments;

@Repository
public interface CommentRepository extends JpaRepository<Comments, Long>{

	List<Comments> findByUserName(String username);

	List<Comments> findByDateofcommentBetween(LocalDateTime startOfDay, LocalDateTime endOfDay);
	
}
