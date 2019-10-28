package com.carriersedge.demo.dao;

import com.carriersedge.demo.entity.Curriculum;
import com.carriersedge.demo.entity.Location;

public interface LocationDAO {
	
	public void saveLocation(Location location);
	
	public Location getLocation(String name);
	
	public void addCurriculum(Location location, Curriculum curriculum);
}
