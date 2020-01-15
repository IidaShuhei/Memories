package com.example.domain;

public class Review {

	private Integer id;
	private Integer star;
	private String reviewTitle;
	private String message;

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
	 * @return the star
	 */
	public Integer getStar() {
		return star;
	}

	/**
	 * @param star the star to set
	 */
	public void setStar(Integer star) {
		this.star = star;
	}

	/**
	 * @return the reviewTitle
	 */
	public String getReviewTitle() {
		return reviewTitle;
	}

	/**
	 * @param reviewTitle the reviewTitle to set
	 */
	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", star=" + star + ", reviewTitle=" + reviewTitle + ", message=" + message + "]";
	}

}
