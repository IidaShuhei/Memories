package com.example.form;

import org.springframework.web.multipart.MultipartFile;

public class ArticleForm {
	private String id;
	private String title;
	private String name;
	private String content;
	private String postDate;
	private MultipartFile imagePath;


	public MultipartFile getImagePath() {
		return imagePath;
	}

	public void setImagePath(MultipartFile imagePath) {
		this.imagePath = imagePath;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPostDate() {
		return postDate;
	}

	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}

}
