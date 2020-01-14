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
	private String transportation;
	private String fare;
	private String hotelName;
	private String hotelFee;
	private String mealFee;
	private String otherAmount;
	private String totalFee;
	private Integer good;
	
	
	
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
	public String getPostDate() {
		return postDate;
	}
	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}
	public MultipartFile getImagePath() {
		return imagePath;
	}
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
	public String getTransportation() {
		return transportation;
	}
	public void setTransportation(String transportation) {
		this.transportation = transportation;
	}
	public String getFare() {
		return fare;
	}
	public void setFare(String fare) {
		this.fare = fare;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getHotelFee() {
		return hotelFee;
	}
	public void setHotelFee(String hotelFee) {
		this.hotelFee = hotelFee;
	}
	public String getMealFee() {
		return mealFee;
	}
	public void setMealFee(String mealFee) {
		this.mealFee = mealFee;
	}
	public String getOtherAmount() {
		return otherAmount;
	}
	public void setOtherAmount(String otherAmount) {
		this.otherAmount = otherAmount;
	}
	public String getTotalFee() {
		return totalFee;
	}
	public void setTotalFee(String totalFee) {
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
		return "ArticleForm [id=" + id + ", title=" + title + ", name=" + name + ", prefecture=" + prefecture
				+ ", content=" + content + ", postDate=" + postDate + ", imagePath=" + imagePath + ", tripStartDate="
				+ tripStartDate + ", tripEndDate=" + tripEndDate + ", transportation=" + transportation + ", fare="
				+ fare + ", hotelName=" + hotelName + ", hotelFee=" + hotelFee + ", mealFee=" + mealFee
				+ ", otherAmount=" + otherAmount + ", totalFee=" + totalFee + ", good=" + good + "]";
	}
	
	




}
