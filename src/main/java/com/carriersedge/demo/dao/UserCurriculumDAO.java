package com.carriersedge.demo.dao;

import java.util.List;

import com.carriersedge.demo.entity.UserCurriculum;

public interface UserCurriculumDAO {

	/**
	 * 
	 * @param UserCurriculum userCurriculum
	 */
	public void saveUserCurriculum(UserCurriculum userCurriculum);
	
	public List<UserCurriculum> getUserCurriculums(String username);
}
