package com.example.form;

public class ReviewForm {

	private String star;
	private String reviewTitle;
	private String message;

	/**
	 * @return the star
	 */
	public String getStar() {
		return star;
	}

	/**
	 * @param star the star to set
	 */
	public void setStar(String star) {
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
		return "ReviewForm [star=" + star + ", reviewTitle=" + reviewTitle + ", message=" + message + "]";
	}

}
