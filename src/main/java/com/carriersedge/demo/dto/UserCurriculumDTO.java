package com.carriersedge.demo.dto;

import java.io.Serializable;

public class UserCurriculumDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long userId;
	
	private boolean secondary;

	public UserCurriculumDTO() {
		
	}
	
	/**
	 * 
	 * @param userId
	 * @param curriculumId
	 */
	public UserCurriculumDTO(long userId, boolean secondary) {
		this.userId = userId;
		this.secondary = secondary;
	}
	
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public boolean isSecondary() {
		return secondary;
	}

	public void setSecondary(boolean secondary) {
		this.secondary = secondary;
	}

}
