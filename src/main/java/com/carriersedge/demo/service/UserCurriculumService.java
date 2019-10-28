package com.carriersedge.demo.service;

import java.util.List;

import com.carriersedge.demo.entity.Curriculum;
import com.carriersedge.demo.entity.User;
import com.carriersedge.demo.entity.UserCurriculum;

public interface UserCurriculumService {
	
	/**
	 * 
	 * @param User user
	 * @param Curriculum curriculum
	 * @param User createdUser
	 */
	public void createUserCurriculum(User user, Curriculum curriculum, User createdUser);
	
	/**
	 * 
	 * @param User user
	 */
	public void createAllUserCurriculums(User user, User createdUser);
	
	
	public List<UserCurriculum>  getUserCurriculums(String username);
	
}
