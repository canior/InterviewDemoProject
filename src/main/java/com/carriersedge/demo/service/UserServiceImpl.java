package com.carriersedge.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.carriersedge.demo.dao.UserDAO;
import com.carriersedge.demo.entity.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	@Override
	@Transactional
	public User getUserById(long id) {
		return userDAO.getUserById(id);
	}

	@Override
	@Transactional
	public User getAdminUser() {
		return userDAO.getAdminUser();
	}

}
