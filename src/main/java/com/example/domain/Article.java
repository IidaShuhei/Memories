package com.example.domain;

import java.util.Date;
import java.util.List;

public class Article {

	private Integer id;
	private String title;
	private String name;
	private String prefecture;
	private String content;
	private Date postDate;
	private String imagePath;
	private List<Comment> commentList;
	private Date tripStartDate;
	private Date tripEndDate;
	private String transportation;
	private Integer fare;
	private String hotelName;
	private Integer hotelFee;
	private Integer mealFee;
	private Integer otherAmount;
	private Integer totalFee;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
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
	public Date getPostDate() {
		return postDate;
	}

	/**
	 * @param postDate the postDate to set
	 */
	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	/**
	 * @return the imagePath
	 */
	public String getImagePath() {
		return imagePath;
	}

	/**
	 * @param imagePath the imagePath to set
	 */
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	/**
	 * @return the commentList
	 */
	public List<Comment> getCommentList() {
		return commentList;
	}

	/**
	 * @param commentList the commentList to set
	 */
	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}

	/**
	 * @return the tripStartDate
	 */
	public Date getTripStartDate() {
		return tripStartDate;
	}

	/**
	 * @param tripStartDate the tripStartDate to set
	 */
	public void setTripStartDate(Date tripStartDate) {
		this.tripStartDate = tripStartDate;
	}

	/**
	 * @return the tripEndDate
	 */
	public Date getTripEndDate() {
		return tripEndDate;
	}

	/**
	 * @param tripEndDate the tripEndDate to set
	 */
	public void setTripEndDate(Date tripEndDate) {
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
	public Integer getFare() {
		return fare;
	}

	/**
	 * @param fare the fare to set
	 */
	public void setFare(Integer fare) {
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
	public Integer getHotelFee() {
		return hotelFee;
	}

	/**
	 * @param hotelFee the hotelFee to set
	 */
	public void setHotelFee(Integer hotelFee) {
		this.hotelFee = hotelFee;
	}

	/**
	 * @return the mealFee
	 */
	public Integer getMealFee() {
		return mealFee;
	}

	/**
	 * @param mealFee the mealFee to set
	 */
	public void setMealFee(Integer mealFee) {
		this.mealFee = mealFee;
	}

	/**
	 * @return the otherAmount
	 */
	public Integer getOtherAmount() {
		return otherAmount;
	}

	/**
	 * @param otherAmount the otherAmount to set
	 */
	public void setOtherAmount(Integer otherAmount) {
		this.otherAmount = otherAmount;
	}

	/**
	 * @return the totalFee
	 */
	public Integer getTotalFee() {
		return totalFee;
	}

	/**
	 * @param totalFee the totalFee to set
	 */
	public void setTotalFee(Integer totalFee) {
		this.totalFee = totalFee;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", name=" + name + ", prefecture=" + prefecture + ", content="
				+ content + ", postDate=" + postDate + ", imagePath=" + imagePath + ", commentList=" + commentList
				+ ", tripStartDate=" + tripStartDate + ", tripEndDate=" + tripEndDate + ", transportation="
				+ transportation + ", fare=" + fare + ", hotelName=" + hotelName + ", hotelFee=" + hotelFee
				+ ", mealFee=" + mealFee + ", otherAmount=" + otherAmount + ", totalFee=" + totalFee + "]";
	}

}
