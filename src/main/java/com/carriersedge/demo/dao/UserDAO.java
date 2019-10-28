package com.carriersedge.demo.dao;

import com.carriersedge.demo.entity.User;

public interface UserDAO {
	
	public User getAdminUser();
	
	public User getUserById(long id);
	
	public void saveUser(User user);
}
