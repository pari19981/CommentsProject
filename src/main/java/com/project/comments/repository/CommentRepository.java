package com.project.comments.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.comments.entity.Comments;

@Repository
public interface CommentRepository extends JpaRepository<Comments, Long>{

	List<Comments> findByUserName(String username);

	List<Comments> findByDateofcommentBetween(LocalDateTime startOfDay, LocalDateTime endOfDay);

	List<Comments> findByUserNameAndDateofcommentBetween(String username, LocalDateTime startOfDay,
			LocalDateTime endOfDay);
	
	@Query(value = "SELECT * FROM comments WHERE By=:username AND (dateofcomment BETWEEN :startOfDay AND :endOfDay)",nativeQuery = true)
	List<Comments> findByUserNameAndDateofcommentBetweenNativeQuery(@Param("username") String username,
			@Param("startOfDay") LocalDateTime startOfDay,
			@Param("endOfDay") LocalDateTime endOfDay);
	
	@Query(value = "SELECT * \r\n"
			+ "FROM comments\r\n"
			+ "WHERE (:username IS NOT NULL AND :DateInput IS NULL and userName =:username)\r\n"
			+ "OR (:username IS NULL and :DateInput IS NOT NULL and (DATE(dateofcomment) >=STR_TO_DATE(:DateInput,'%Y-%c-%d') AND DATE(dateofcomment)<=STR_TO_DATE(:DateInput,'%Y-%c-%d')))\r\n"
			+ "OR (:username IS NOT NULL AND :DateInput IS NOT NULL AND userName=:username and (DATE(dateofcomment) >=STR_TO_DATE(:DateInput,'%Y-%c-%d') AND DATE(dateofcomment)<=STR_TO_DATE(:DateInput,'%Y-%c-%d')))",nativeQuery = true)
	List<Map<String,Object>> findByUserNameAndDateofcommentBetweenNativeQueryDynamic(@Param("username") String username,
			@Param("DateInput") String DateInput);
	
}
