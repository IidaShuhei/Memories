package com.example.form;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

public class ArticleForm {
	private String id;
	private String userId;
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
	private String tripStartDate;
	private String tripEndDate;
	private String transportation;
	private String fare;
	private String hotelName;
	private String hotelFee;
	private String mealFee;
	private String otherAmount;
	private String totalFee;
	private Integer good;

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
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
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

	/**
	 * @return the tripStartDate
	 */
	public String getTripStartDate() {
		return tripStartDate;
	}

	/**
	 * @param tripStartDate the tripStartDate to set
	 */
	public void setTripStartDate(String tripStartDate) {
		this.tripStartDate = tripStartDate;
	}

	/**
	 * @return the tripEndDate
	 */
	public String getTripEndDate() {
		return tripEndDate;
	}

	/**
	 * @param tripEndDate the tripEndDate to set
	 */
	public void setTripEndDate(String tripEndDate) {
		this.tripEndDate = tripEndDate;
	}

	/**
	 * @return the transportation
	 */
	public String getTransportation() {
		return transportation;
	}

	/**
	 * @param transportation the transportation to set
	 */
	public void setTransportation(String transportation) {
		this.transportation = transportation;
	}

	/**
	 * @return the fare
	 */
	public String getFare() {
		return fare;
	}

	/**
	 * @param fare the fare to set
	 */
	public void setFare(String fare) {
		this.fare = fare;
	}

	/**
	 * @return the hotelName
	 */
	public String getHotelName() {
		return hotelName;
	}

	/**
	 * @param hotelName the hotelName to set
	 */
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	/**
	 * @return the hotelFee
	 */
	public String getHotelFee() {
		return hotelFee;
	}

	/**
	 * @param hotelFee the hotelFee to set
	 */
	public void setHotelFee(String hotelFee) {
		this.hotelFee = hotelFee;
	}

	/**
	 * @return the mealFee
	 */
	public String getMealFee() {
		return mealFee;
	}

	/**
	 * @param mealFee the mealFee to set
	 */
	public void setMealFee(String mealFee) {
		this.mealFee = mealFee;
	}

	/**
	 * @return the otherAmount
	 */
	public String getOtherAmount() {
		return otherAmount;
	}

	/**
	 * @param otherAmount the otherAmount to set
	 */
	public void setOtherAmount(String otherAmount) {
		this.otherAmount = otherAmount;
	}

	/**
	 * @return the totalFee
	 */
	public String getTotalFee() {
		return totalFee;
	}

	/**
	 * @param totalFee the totalFee to set
	 */
	public void setTotalFee(String totalFee) {
		this.totalFee = totalFee;
	}

	/**
	 * @return the good
	 */
	public Integer getGood() {
		return good;
	}

	/**
	 * @param good the good to set
	 */
	public void setGood(Integer good) {
		this.good = good;
	}

	@Override
	public String toString() {
		return "ArticleForm [id=" + id + ", userId=" + userId + ", title=" + title + ", name=" + name + ", prefecture="
				+ prefecture + ", content=" + content + ", postDate=" + postDate + ", imagePath=" + imagePath
				+ ", tripStartDate=" + tripStartDate + ", tripEndDate=" + tripEndDate + ", transportation="
				+ transportation + ", fare=" + fare + ", hotelName=" + hotelName + ", hotelFee=" + hotelFee
				+ ", mealFee=" + mealFee + ", otherAmount=" + otherAmount + ", totalFee=" + totalFee + ", good=" + good
				+ "]";
	}

}
