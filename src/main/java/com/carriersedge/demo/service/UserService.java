package com.carriersedge.demo.service;

import com.carriersedge.demo.entity.User;

public interface UserService {
	
	public User getUserById(long id);
	
	public User getAdminUser();
	
}
