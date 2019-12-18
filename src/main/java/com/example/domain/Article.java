package com.example.domain;

import java.util.Date;


public class Article {

	private Integer id;
	private String title;
	private String name;
	private String prefecture;
	private String content;
	private Date postDate;
	private String imagePath;
	
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getPrefecture() {
		return prefecture;
	}
	
	public void setPrefecture(String prefecture) {
		this.prefecture = prefecture;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", name=" + name + ", prefecture=" + prefecture
				+ ", content=" + content + ", postDate=" + postDate + ", imagePath=" + imagePath + "]";
	}



    





}
