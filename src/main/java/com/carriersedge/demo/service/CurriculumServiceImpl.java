package com.carriersedge.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carriersedge.demo.dao.CurriculumDAO;
import com.carriersedge.demo.entity.Curriculum;

@Service
public class CurriculumServiceImpl implements CurriculumService{

	@Autowired
	private CurriculumDAO curriculumDAO;
	
	@Override
	public Curriculum getCurriculumById(long id) {
		return curriculumDAO.getCurriculumById(id);
	}

}
