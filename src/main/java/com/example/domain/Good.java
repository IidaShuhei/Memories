package com.example.domain;

public class Good {

	private Integer id;
	private Integer userId;
	private Integer goodId;

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
	 * @return the userId
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * @return the goodId
	 */
	public Integer getGoodId() {
		return goodId;
	}

	/**
	 * @param goodId the goodId to set
	 */
	public void setGoodId(Integer goodId) {
		this.goodId = goodId;
	}

	@Override
	public String toString() {
		return "Good [id=" + id + ", userId=" + userId + ", goodId=" + goodId + "]";
	}

}
