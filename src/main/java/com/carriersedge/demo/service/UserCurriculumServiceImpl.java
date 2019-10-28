package com.carriersedge.demo.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.carriersedge.demo.dao.UserCurriculumDAO;
import com.carriersedge.demo.entity.Curriculum;
import com.carriersedge.demo.entity.Location;
import com.carriersedge.demo.entity.User;
import com.carriersedge.demo.entity.UserCurriculum;

@Service
public class UserCurriculumServiceImpl implements UserCurriculumService {

	@Autowired
    private UserCurriculumDAO userCurriculumDAO;
	

	@Override
	@Transactional
	public void createUserCurriculum(User user, Curriculum curriculum, User createdBy) {
		UserCurriculum userCurriculum = new UserCurriculum(user, curriculum, createdBy);
		userCurriculumDAO.saveUserCurriculum(userCurriculum);
	}

	@Override
	@Transactional
	public void createAllUserCurriculums(User user, User createdBy) {
		Location location = user.getLocation();
		Set<Curriculum> curriculums = location.getCurriculums();
		for (Curriculum curriculum : curriculums) {
			this.createUserCurriculum(user, curriculum, createdBy);
		}
	}

	

	@Override
	@Transactional
	public List<UserCurriculum>  getUserCurriculums(String username) {
		return userCurriculumDAO.getUserCurriculums(username);
	}

}
