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
	private Integer good;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public List<Comment> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}

	public Date getTripStartDate() {
		return tripStartDate;
	}

	public void setTripStartDate(Date tripStartDate) {
		this.tripStartDate = tripStartDate;
	}

	public Date getTripEndDate() {
		return tripEndDate;
	}

	public void setTripEndDate(Date tripEndDate) {
		this.tripEndDate = tripEndDate;
	}

	public String getTransportation() {
		return transportation;
	}

	public void setTransportation(String transportation) {
		this.transportation = transportation;
	}

	public Integer getFare() {
		return fare;
	}

	public void setFare(Integer fare) {
		this.fare = fare;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public Integer getHotelFee() {
		return hotelFee;
	}

	public void setHotelFee(Integer hotelFee) {
		this.hotelFee = hotelFee;
	}

	public Integer getMealFee() {
		return mealFee;
	}

	public void setMealFee(Integer mealFee) {
		this.mealFee = mealFee;
	}

	public Integer getOtherAmount() {
		return otherAmount;
	}

	public void setOtherAmount(Integer otherAmount) {
		this.otherAmount = otherAmount;
	}

	public Integer getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(Integer totalFee) {
		this.totalFee = totalFee;
	}

	public Integer getGood() {
		return good;
	}

	public void setGood(Integer good) {
		this.good = good;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", name=" + name + ", prefecture=" + prefecture + ", content="
				+ content + ", postDate=" + postDate + ", imagePath=" + imagePath + ", commentList=" + commentList
				+ ", tripStartDate=" + tripStartDate + ", tripEndDate=" + tripEndDate + ", transportation="
				+ transportation + ", fare=" + fare + ", hotelName=" + hotelName + ", hotelFee=" + hotelFee
				+ ", mealFee=" + mealFee + ", otherAmount=" + otherAmount + ", totalFee=" + totalFee + ", good=" + good
				+ "]";
	}

}
