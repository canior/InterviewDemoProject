package com.carriersedge.demo.dao;

import com.carriersedge.demo.entity.Curriculum;

public interface CurriculumDAO {
	
	public Curriculum getCurriculumById(long id);
	
	public Curriculum getCurriculum(String name);
	
	public void saveCurriculum(Curriculum curriculum);
}
