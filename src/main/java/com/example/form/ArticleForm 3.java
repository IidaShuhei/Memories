package com.example.form;


import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

public class ArticleForm {
	private String id;
	@NotBlank(message = "タイトルは必須です")
	@Length(min = 1, max = 25, message = "タイトルは1文字以上25文字以内で記載してください")
	private String title;
	@NotBlank(message = "名前は必須です")
	private String name;
	@NotBlank(message = "県名は必須です")
	private String prefecture;
	@NotBlank(message = "内容は必須です")
	private String content;
	private String postDate;
	private MultipartFile imagePath;
//	@NotBlank(message="旅行開始日は必須です")
	private String tripStartDate;
	
	private String tripEndDate;



	@Override
	public String toString() {
		return "ArticleForm [id=" + id + ", title=" + title + ", name=" + name + ", prefecture=" + prefecture
				+ ", content=" + content + ", postDate=" + postDate + ", imagePath=" + imagePath + ", tripStartDate="
				+ tripStartDate + ", tripEndDate=" + tripEndDate + "]";
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the prefecture
	 */
	public String getPrefecture() {
		return prefecture;
	}

	/**
	 * @param prefecture the prefecture to set
	 */
	public void setPrefecture(String prefecture) {
		this.prefecture = prefecture;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the postDate
	 */
	public String getPostDate() {
		return postDate;
	}

	/**
	 * @param postDate the postDate to set
	 */
	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}

	/**
	 * @return the imagePath
	 */
	public MultipartFile getImagePath() {
		return imagePath;
	}

	/**
	 * @param imagePath the imagePath to set
	 */
	public void setImagePath(MultipartFile imagePath) {
		this.imagePath = imagePath;
	}

	public String getTripStartDate() {
		return tripStartDate;
	}

	public void setTripStartDate(String tripStartDate) {
		this.tripStartDate = tripStartDate;
	}

	public String getTripEndDate() {
		return tripEndDate;
	}

	public void setTripEndDate(String tripEndDate) {
		this.tripEndDate = tripEndDate;
	}

}
