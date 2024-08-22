package com.project.comments.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "comments")
public class Comments {

	@Id
	@Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@Column(name = "userName",nullable = false)
	private String userName;
	
	@Column(name = "Text",nullable = false)
	private String text;
	
	@Column(name = "dateofcomment",nullable = false)
	private LocalDateTime dateofcomment;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public LocalDateTime getDateofcomment() {
		return dateofcomment;
	}

	public void setDateofcomment(LocalDateTime dateofcomment) {
		this.dateofcomment = dateofcomment;
	}

	
}
